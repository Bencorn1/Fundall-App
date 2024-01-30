package com.ayotola.fundall_app

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
    }
}