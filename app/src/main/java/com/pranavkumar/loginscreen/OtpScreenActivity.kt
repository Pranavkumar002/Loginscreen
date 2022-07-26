package com.pranavkumar.loginscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.widget.doOnTextChanged

class OtpScreenActivity : AppCompatActivity() {

    lateinit var ivOtp: ImageView
    lateinit var tvTextcode: TextView
    lateinit var tvEnterotp: TextView
    lateinit var etOtp1: EditText
    lateinit var etOtp2: EditText
    lateinit var etOtp3: EditText
    lateinit var etOtp4: EditText
    lateinit var btnVerify: Button
    lateinit var tvResend: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.otp_screen_main)
        ivOtp = findViewById(R.id.ivOtp)
        tvTextcode = findViewById(R.id.tvTextcode)
        tvEnterotp = findViewById(R.id.tvEnterotp)
        etOtp1 = findViewById(R.id.etOtp1)
        etOtp2 = findViewById(R.id.etOtp2)
        etOtp3 = findViewById(R.id.etOtp3)
        etOtp4 = findViewById(R.id.etOtp4)
        btnVerify = findViewById(R.id.btnVerify)
        tvResend = findViewById(R.id.tvResend)

        etOtp1.doOnTextChanged {text,_,_,_->
            if((text?.length?:0)>0){
                etOtp2.requestFocus()
            }

            etOtp2.doOnTextChanged{text,_,_,_->
                if((text?.length?:0)>0){
                    etOtp3.requestFocus()
                }
                etOtp3.doOnTextChanged{text,_,_,_->
                    if((text?.length?:0)>0){
                        etOtp4.requestFocus()
                    }





        btnVerify.setOnClickListener{
            Toast.makeText(this,resources.getString(R.string.otp_verify), Toast.LENGTH_LONG).show()

        }




            }

            }
        }
    }
}