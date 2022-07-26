package com.pranavkumar.loginscreen

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged


class RegisterActivity : AppCompatActivity() {
    lateinit var etFirstName: EditText
    lateinit var etLastName: EditText
    lateinit var etEnterEmail: EditText
    lateinit var etSetPassword: EditText
    lateinit var rgGender: RadioGroup
    lateinit var rbMale: RadioButton
    lateinit var rbFemale: RadioButton
    lateinit var rbTransgender: RadioButton
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
        rbTransgender = findViewById(R.id.rbTransgender)
        rgGender = findViewById(R.id.rgGender)
        btnSubmit = findViewById(R.id.btnSubmit)

        etSetPassword.doOnTextChanged { text, _, _, _ ->
            if((text?.length ?:0) <6){
                etSetPassword.error = resources.getString(R.string.at_least_6_numbers)

            }else{
                etSetPassword.error = null
            }
        }



        btnSubmit.setOnClickListener{
            System.out.println("clicked")
            var enteremail = etEnterEmail.text.toString()
            var enterfirstname = etFirstName.text.toString()
            var enterlastname = etLastName.text.toString()
            var setpassword = etSetPassword.text.toString()
            System.out.println("enteremail $enteremail")
            if (enterfirstname.isNullOrEmpty())
            {
                etFirstName.error = resources.getString(R.string.enter_first_name)
                etFirstName.requestFocus()
            }
            else if (enterlastname.isNullOrEmpty())
            {
                etLastName.error = resources.getString(R.string.enter_last_name)
                etLastName.requestFocus()
            }

            else if (enteremail.isNullOrEmpty())
            {
                etEnterEmail.error = resources.getString(R.string.please_enter_email)
                etEnterEmail.requestFocus()
            }
            else if (setpassword.isNullOrEmpty())
            {
                etSetPassword.error = resources.getString(R.string.at_least_6_numbers)

            }


            else
            {
                Toast.makeText(this, resources.getString(R.string.submit_successfully), Toast.LENGTH_LONG).show()
            }
        }








        }


    }
