package com.ayotola.fundall_app.authentication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ayotola.fundall_app.CreateUserRequest
import com.ayotola.fundall_app.CreateUserViewModel
import com.ayotola.fundall_app.databinding.ActivitySignupBinding
import com.ayotola.fundall_app.sharedpreference.Preferences
import com.ayotola.fundall_app.showMessage
import dagger.hilt.android.AndroidEntryPoint
import java.util.regex.Pattern
import javax.inject.Inject

@AndroidEntryPoint
class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    private  val viewModel: CreateUserViewModel by viewModels()

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cancelBtn.setOnClickListener {

        }

        binding.benefitsBtn.setOnClickListener {

        }

        binding.signupInvite.setOnClickListener {

        }

        binding.signupButton.setOnClickListener {
            if (isValid() && verifyEmail(binding.emailAddress.text.toString()) && verifyPhoneNumber(
                    binding.phoneNumber.text.toString())) {

               signup()

            } else {
                Toast.makeText(this, "Please input valid Credentials", Toast.LENGTH_LONG).show()
            }

        }

        setupObserver()

        binding.loginBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.footer.setOnClickListener {

        }

    }

    private fun isValid(): Boolean {
        var isValid = true

        if (binding.fnameEditText.text.isEmpty()) {
            binding.fnameEditText.error = "First name can't be empty"
            isValid = false
        } else {

        }

        if (binding.lnameEditText.text.isEmpty()) {
            binding.lnameEditText.error = "Last name can't be empty"
            isValid = false
        } else {

        }

        if (binding.emailAddress.text.isEmpty()) {
            binding.emailAddress.error = "Email address can't be empty"
            isValid = false
        } else {

        }

        if (binding.phoneNumber.text.isEmpty()) {
            binding.phoneNumber.error = "Phone number can't be empty"
            isValid = false
        } else {

        }

        if (binding.password.text.isEmpty()) {
            binding.password.error = "Password can't be empty"
            isValid = false
        } else {

        }

        return isValid

    }

    private fun verifyEmail(email: String): Boolean {
        val emailPATTERN = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"

        val emailPattern = Pattern.compile(emailPATTERN)
        val matcher = emailPattern.matcher(email)
        return matcher.matches()
    }

    private fun verifyPhoneNumber(phoneNumber: String): Boolean {
        val phoneNumPATTERN = "^[+]?[0-9]{10,13}$"

        val phoneNumberPattern = Pattern.compile(phoneNumPATTERN)
        val matcher = phoneNumberPattern.matcher(phoneNumber)
        return matcher.matches()
    }


    private fun showLoading() {
        binding.signupButton.isEnabled = false
        binding.progress.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        binding.signupButton.isEnabled
        binding.progress.visibility = View.GONE
    }


    private fun setupObserver() {
        viewModel.state.observe(this, Observer {

            if (it.loading) showLoading() else hideLoading()

            if (it.data != null) {
                val intent = Intent(this@SignupActivity, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }

            if (it.error != null && !it.error.hasBeenHandled) {
                showMessage(it.error.peekContent())
            }
        })
    }


    private fun signup() {
        val request = CreateUserRequest(binding.fnameEditText.text.toString(), binding.lnameEditText.text.toString(),
                binding.emailAddress.text.toString(), binding.password.text.toString(), binding.password.text.toString())

        val inputtedEmail = binding.emailAddress.text.toString()
        preferences.setEmail(inputtedEmail)

        val inputtedName = binding.fnameEditText.text.toString()
        preferences.setName(inputtedName)

        val accessToken = "API_TOKEN"
        val aToken = "Bearer $accessToken"

        viewModel.createUser(aToken, request)

    }

}