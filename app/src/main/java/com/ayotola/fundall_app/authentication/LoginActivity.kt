package com.ayotola.fundall_app.authentication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ayotola.fundall_app.*
import com.ayotola.fundall_app.databinding.ActivityLoginBinding
import com.ayotola.fundall_app.sharedpreference.Preferences
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private  val viewModel: LoginViewmodel by viewModels()

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cancelBtn.setOnClickListener {

        }

        val message = intent.getStringExtra("Email_Address")
        binding.userEmail.text = message

        binding.userEmail.text = preferences.getEmail()

        binding.userText.text = "We miss you, ${preferences.getName()}"

        binding.loginButton.setOnClickListener {
            if (isValid()) {

                login()

            } else {
                Toast.makeText(this, "Please input correct password", Toast.LENGTH_LONG).show()
            }

        }

        setupObserver()

        binding.createBtn.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

    }

    private fun isValid(): Boolean {
        var isValid = true

        if (binding.password.text.isEmpty()) {
            binding.password.error = "Password can't be empty"
            isValid = false
        } else {

        }

        return isValid

    }

    private fun showLoading() {
        binding.loginButton.isEnabled = false
        binding.progress.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        binding.loginButton.isEnabled
        binding.progress.visibility = View.GONE
    }


    private fun setupObserver() {
        viewModel.state.observe(this, Observer {

            if (it.loading) showLoading() else hideLoading()

            if (it.data != null) {

                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK


                intent.putExtra("Monthly_target", it.data.success?.user?.monthlyTarget)

                startActivity(intent)
                finish()
            }

            if (it.error != null && !it.error.hasBeenHandled) {
                showMessage(it.error.peekContent())
            }
        })
    }


    private fun login() {
        val request = LoginRequest(binding.userEmail.text.toString(), binding.password.text().toString())

        Timber.d("Login Request: $request")
        val accessToken = "API_TOKEN"
        val aToken = "Bearer $accessToken"

        viewModel.login(aToken, request)

    }


}