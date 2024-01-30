package com.ayotola.fundall_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayotola.fundall_app.databinding.ActivityLoginBinding
import com.ayotola.fundall_app.databinding.ActivitySignupBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cancelBtn.setOnClickListener {
            finish()
        }

        binding.loginButton.setOnClickListener {
            binding.password.text.toString()

        }

        binding.createBtn.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}