package com.example.homework11052021

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework11052021.databinding.ProfileInfoBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ProfileInfoBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_info)
        binding = ProfileInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clearBtn.setOnLongClickListener { clear() }
        binding.saveBtn.setOnClickListener { validateInput() }

    }


    private fun validateInput(): Boolean {
        val email = binding.emailTxt.text
        val userName = binding.userNameTxt.text
        val firstName = binding.firstNameTxt.text
        val lastName = binding.lastNameTxt.text
        val age = binding.ageTxt.text


        val minUserNameCharacter = 10

        //checking all fields state
        if (email.isEmpty() || age.isEmpty() || userName.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            Toast.makeText(this@MainActivity, "Please fill all fields", Toast.LENGTH_LONG).show()
            return false
        }

        // checking if all Numbers is digit
        if (!age.all { it.isDigit() }) {
            Toast.makeText(
                this@MainActivity,
                "Please enter valid numbers in age fields",
                Toast.LENGTH_LONG
            ).show()
            return false
        }

        // checking the proper email format
        if (!isEmailValid(email.toString())) {
            Toast.makeText(this@MainActivity, "Please enter valid email", Toast.LENGTH_LONG).show()
            return false
        }

        // checking minimum username Length
        if (userName.length < minUserNameCharacter) {
            Toast.makeText(
                this@MainActivity,
                "Username length must be more than 10 characters",
                Toast.LENGTH_LONG
            ).show()
            return false
        }

        return true
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun clear(): Boolean {
        binding.emailTxt.text.clear()
        binding.userNameTxt.text.clear()
        binding.firstNameTxt.text.clear()
        binding.lastNameTxt.text.clear()
        binding.ageTxt.text.clear()

        return true

    }

}


