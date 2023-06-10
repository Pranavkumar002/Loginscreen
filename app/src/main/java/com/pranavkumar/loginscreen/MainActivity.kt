package com.pranavkumar.loginscreen

import android.content.ContentValues
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pranavkumar.loginscreen.databinding.LoginMainBinding

import java.util.Locale

class MainActivity : AppCompatActivity(),BcrInterface {
    lateinit var binding: LoginMainBinding
    private var auth: FirebaseAuth = Firebase.auth
    lateinit var sharedPreferences : SharedPreferences
    lateinit var bcReceiver: BCReceiver
    lateinit var alertDialog: AlertDialog.Builder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        alertDialog = AlertDialog.Builder(this)
        bcReceiver = BCReceiver()
        bcReceiver.initializeInterface(this)
        sharedPreferences = this.getSharedPreferences(resources.getString(R.string.app_name), MODE_PRIVATE)
        supportActionBar?.hide()
        val langauge = sharedPreferences.getString("locale","hi")?:"hi"
        val locale = Locale(langauge)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        createConfigurationContext(config)
        resources.updateConfiguration(config,resources.displayMetrics)
        val intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(bcReceiver,intentFilter)


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
    override fun OnAirplaneMode(isAirplaneModeEnabled: Boolean) {

        if (isAirplaneModeEnabled) {
            alertDialog.setTitle("Airplane Mode ")
            alertDialog.setMessage("Please Turn off your phone airplane mode")
            alertDialog.setPositiveButton("ok"){_,_->

            }
            alertDialog.setNegativeButton("Cancel"){_,_->

            }
            alertDialog.show()

        } else {
            System.out.println("in mode else $isAirplaneModeEnabled")
        }
    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
//        updateUI(currentUser)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(bcReceiver)
    }


}