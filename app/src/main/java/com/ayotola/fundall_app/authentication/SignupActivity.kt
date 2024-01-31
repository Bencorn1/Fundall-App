package com.ayotola.fundall_app.authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ayotola.fundall_app.databinding.ActivitySignupBinding
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

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
            binding.fnameEditText.text.toString()
            binding.lnameEditText.text.toString()
            binding.emailAddress.text.toString()
            binding.phoneNumber.text.toString()
            binding.password.text.toString()

            if (isValid() && verifyEmail(binding.emailAddress.text.toString()) && verifyPhoneNumber(
                    binding.phoneNumber.text.toString())) {

                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("Email_Address", binding.emailAddress.text.toString())
                startActivity(intent)

            } else {
                Toast.makeText(this, "Please input valid Credentials", Toast.LENGTH_LONG).show()
            }

        }

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

}