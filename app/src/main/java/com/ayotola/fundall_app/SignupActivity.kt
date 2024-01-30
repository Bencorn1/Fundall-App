package com.ayotola.fundall_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayotola.fundall_app.databinding.ActivitySignupBinding
import com.ayotola.fundall_app.databinding.ActivitySplashScreenBinding

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

        }

        binding.loginBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.footer.setOnClickListener {

        }
    }
}