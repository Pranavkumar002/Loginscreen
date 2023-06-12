package com.pranavkumar.loginscreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pranavkumar.loginscreen.databinding.NotificationServiceBinding

class NotificationActivity : AppCompatActivity(){
    lateinit var binding: NotificationServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NotificationServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnStart.setOnClickListener{
            val input: String = binding.editText.text.toString()
            val serviceIntent = Intent(this, NotificationService::class.java)
            serviceIntent.putExtra("inputExtra", input)
            ContextCompat.startForegroundService(this, serviceIntent)
        }
        binding.btnStop.setOnClickListener{
            val serviceIntent = Intent(this, NotificationService::class.java)
            stopService(serviceIntent)
        }
    }

}