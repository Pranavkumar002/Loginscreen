package com.pranavkumar.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.*
import androidx.core.widget.doOnTextChanged
import com.pranavkumar.loginscreen.databinding.LoginMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: LoginMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnRegister.setOnClickListener{
            var intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnForgot.setOnClickListener{
            var intent =Intent(this,ForgotPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.etPassword.doOnTextChanged { text, _, _, _ ->
            if((text?.length ?:0) <6){
                binding.etPassword.error = resources.getString(R.string.please_enter_password)
            }else{
                binding.etPassword.error = null
            }
        }




        binding.btnLogin.setOnClickListener{
      System.out.println("clicked")
      var email = binding.etEmail.text.toString()
      var password = binding.etPassword.text.toString()
      System.out.println("email $email")
      if (email.isNullOrEmpty())
      {
          binding.etEmail.error = resources.getString(R.string.please_enter_email)
          binding.etEmail.requestFocus()
      }
      else if (password.isNullOrEmpty())
      {
          binding.etPassword.error = resources.getString(R.string.please_enter_password)
          binding.etPassword.requestFocus()
      }
      else
      {
          Toast.makeText(this, resources.getString(R.string.login_successfully), Toast.LENGTH_LONG).show()
      }
  }
        binding.ivGoogle.setOnClickListener{
      Toast.makeText(this,resources.getString(R.string.google), Toast.LENGTH_SHORT).show()
  }
        binding.ivFacebook.setOnClickListener{
      Toast.makeText(this,resources.getString(R.string.facebook), Toast.LENGTH_SHORT).show()
  }
        binding.ivTwitter.setOnClickListener{
      Toast.makeText(this,resources.getString(R.string.twitter), Toast.LENGTH_SHORT).show()
  }




}
}