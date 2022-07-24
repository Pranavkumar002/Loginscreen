package com.pranavkumar.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.*
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var tvForgot: TextView
    lateinit var btnLogin: Button
    lateinit var ivGoogle: ImageView
    lateinit var ivFacebook: ImageView
    lateinit var ivTwitter: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_main)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        tvForgot = findViewById(R.id.tvForgot)
        btnLogin = findViewById(R.id.btnLogin)
        ivGoogle = findViewById(R.id.ivGoogle)
        ivFacebook = findViewById(R.id.ivFacebook)
        ivTwitter = findViewById(R.id.ivTwitter)

        etPassword.doOnTextChanged { text, _, _, _ ->
            if((text?.length ?:0) <6){
                etPassword.error = resources.getString(R.string.please_enter_password)
            }else{
                etPassword.error = null
            }
        }




  btnLogin.setOnClickListener{
      System.out.println("clicked")
      var email = etEmail.text.toString()
      var password = etPassword.text.toString()
      System.out.println("username $email")
      if (email.isNullOrEmpty())
      {
          etEmail.error = resources.getString(R.string.please_enter_username)
          etEmail.requestFocus()
      }
      else if (password.isNullOrEmpty())
      {
          etPassword.error = resources.getString(R.string.please_enter_password)
          etPassword.requestFocus()
      }
      else
      {
          Toast.makeText(this, resources.getString(R.string.login_successfully), Toast.LENGTH_LONG).show()
          var intent = Intent(this, RegisterActivity::class.java)
          startActivity(intent)
          finish()
      }
  }
  ivGoogle.setOnClickListener{
      Toast.makeText(this,resources.getString(R.string.google), Toast.LENGTH_SHORT).show()
  }
  ivFacebook.setOnClickListener{
      Toast.makeText(this,resources.getString(R.string.facebook), Toast.LENGTH_SHORT).show()
  }
  ivTwitter.setOnClickListener{
      Toast.makeText(this,resources.getString(R.string.twitter), Toast.LENGTH_SHORT).show()
  }




}
}