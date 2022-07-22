package com.pranavkumar.loginscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var tvForgot: TextView
    lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        tvForgot = findViewById(R.id.tvForgot)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener{
            System.out.println("clicked")
            var username = etUsername.text.toString()
            var password = etPassword.text.toString()
            System.out.println("username $username")
            if (username.isNullOrEmpty())
            {
                etUsername.error = resources.getString(R.string.please_enter_username)
                etUsername.requestFocus()
            }
            else if (password.isNullOrEmpty())
            {
                etPassword.error = resources.getString(R.string.please_enter_password)
                etPassword.requestFocus()
            }
            else
            {
                Toast.makeText(this, resources.getString(R.string.login_successfully), Toast.LENGTH_LONG).show()
            }
        }

    }
}