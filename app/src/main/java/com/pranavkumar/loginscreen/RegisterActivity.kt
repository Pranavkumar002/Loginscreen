package com.pranavkumar.loginscreen

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity



class RegisterActivity : AppCompatActivity() {
    lateinit var etFirstName: EditText
    lateinit var etLastName: EditText
    lateinit var etEnterEmail: EditText
    lateinit var etSetPassword: EditText
    lateinit var rgGender: RadioGroup
    lateinit var rbMale: RadioButton
    lateinit var rbFemale: RadioButton
    lateinit var rbOther: RadioButton
    lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_main)
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etEnterEmail = findViewById(R.id.etEnterEmail)
        etSetPassword = findViewById(R.id.etSetPassword)
        rbMale = findViewById(R.id.rbMale)
        rbFemale = findViewById(R.id.rbFemale)
        rbOther = findViewById(R.id.rbOther)
        rgGender = findViewById(R.id.rgGender)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener(){
            Toast.makeText(this, resources.getString(R.string.submit_successfully), Toast.LENGTH_LONG).show()
        }

        }


    }
