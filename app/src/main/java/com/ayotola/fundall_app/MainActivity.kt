package com.ayotola.fundall_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.ayotola.fundall_app.databinding.ActivityMainBinding
import com.ayotola.fundall_app.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val navInflater = navController.navInflater

        val graph = navInflater.inflate(R.navigation.main_navigation)
        navController.graph = graph

//        val customDialogFragment = DialogFragment()
//        customDialogFragment.show(supportFragmentManager, "CustomDialogFragment")

        val money = intent.getStringExtra("Monthly_target")

        // Create a Fragment instance and pass the data
        val fragment = HomeFragment()
        val bundle = Bundle()

        bundle.putString("Monthly_target", money)

        fragment.arguments = bundle

    }
}