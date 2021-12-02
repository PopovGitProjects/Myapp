package com.popov.myapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import com.popov.myapp.constants.Constants
import com.popov.myapp.databinding.ActivitySignInUpBinding

class SignInUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.getIntExtra(Constants.SIGN_STATE, 0) == Constants.SIGN_IN_STATE){
            binding.userAvatar.visibility = View.GONE
            binding.saveAvatar.visibility = View.GONE
            binding.userFirstName.visibility = View.GONE
            binding.userLastName.visibility = View.GONE
        }
        binding.saveAvatar.setOnClickListener {
            binding.userAvatar.visibility = View.VISIBLE
            binding.userAvatar.setImageDrawable(R.drawable.hacker.toDrawable())
        }
        binding.okButton.setOnClickListener {

        }

    }
}