package com.pranavkumar.loginscreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var ivForgot: ImageView
    lateinit var tvText: TextView
    lateinit var etEnterEmail: EditText
    lateinit var etPhonenumber: EditText
    lateinit var btnSend: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgotpassword_main)
        ivForgot = findViewById(R.id.ivForgot)
        tvText = findViewById(R.id.tvText)
        etEnterEmail = findViewById(R.id.etEnterEmail)
        etPhonenumber = findViewById(R.id.etPhonenumber)
        btnSend = findViewById(R.id.btnSend)

        btnSend.setOnClickListener{
            var intent = Intent(this,OtpScreenActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}