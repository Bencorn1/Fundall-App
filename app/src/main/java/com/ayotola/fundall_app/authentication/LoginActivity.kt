package com.ayotola.fundall_app.authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ayotola.fundall_app.MainActivity
import com.ayotola.fundall_app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cancelBtn.setOnClickListener {

        }

        // Receive the data from the Intent
        val message = intent.getStringExtra("Email_Address")
        binding.userEmail.text = message

        binding.loginButton.setOnClickListener {
            binding.password.text.toString()

            if (isValid()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please input correct password", Toast.LENGTH_LONG).show()
            }

        }

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

}