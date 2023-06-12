package com.pranavkumar.loginscreen

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class InternetReceiver : BroadcastReceiver() {
    lateinit var internetBcrInterface: InternetBcrInterface
    override fun onReceive(p0: Context?, p1: Intent?) {

    }
    fun initializeInterface(internetBcrInterface: InternetBcrInterface){
        this.internetBcrInterface = internetBcrInterface
    }

}