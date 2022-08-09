package com.pranavkumar.loginscreen

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged

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





        etPhonenumber.doOnTextChanged { text, _, _, _ ->
            if((text?.length ?:0) <10){
                etPhonenumber.error = resources.getString(R.string.enter_10_numbers)

            }else{
                etPhonenumber.error = null
            }
        }


        btnSend.setOnClickListener {

            System.out.println("clicked")
            var enteremail = etEnterEmail.text.toString()
            var phonenumber = etPhonenumber.text.toString()
            System.out.println("enteremail $enteremail")
            if (enteremail.isNullOrEmpty()) {
                etEnterEmail.error = resources.getString(R.string.enter_email)
                etEnterEmail.requestFocus()
            } else if (phonenumber.isNullOrEmpty()) {
                etPhonenumber.error = resources.getString(R.string.enter_10_numbers)
                etPhonenumber.requestFocus()
            } else {
                Toast.makeText(this,resources.getString(R.string.send_otp), Toast.LENGTH_SHORT).show()
                var intent = Intent(this, OtpScreenActivity::class.java)
                startActivity(intent)
                finish()
            }


        }
    }
}
