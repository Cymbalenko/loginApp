package com.navsupport.loginapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.s95ammar.loginapp.R
import com.navsupport.loginapp.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.fragments.isEmpty())
            addLoginFragment()
    }

    private fun addLoginFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, LoginFragment())
            .commit()
    }

}