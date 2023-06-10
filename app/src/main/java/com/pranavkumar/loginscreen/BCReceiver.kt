package com.pranavkumar.loginscreen

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AlertDialog

class BCReceiver:BroadcastReceiver() {
    lateinit var bcrInterface: BcrInterface
    override fun onReceive(p0: Context, p1: Intent?) {

        var state = p1?.getBooleanExtra("state", false)?:false
        bcrInterface.OnAirplaneMode(state)

    }

     fun initializeInterface(bcrInterface: BcrInterface){
        this.bcrInterface = bcrInterface
    }
}