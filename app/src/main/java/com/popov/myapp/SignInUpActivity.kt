package com.popov.myapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.popov.myapp.constants.Constants
import com.popov.myapp.databinding.ActivitySignInUpBinding

class SignInUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("INTENT_DATA", intent.getStringExtra(Constants.SIGN_STATE)!!)
        val intentGetExtra = intent.getStringExtra(Constants.SIGN_STATE)

        if(intentGetExtra.equals(Constants.SIGN_IN_STATE)){
            binding.userAvatar.visibility = View.GONE
            binding.saveAvatar.visibility = View.GONE
            binding.userFirstName.visibility = View.GONE
            binding.userLastName.visibility = View.GONE
        }
        binding.saveAvatar.setOnClickListener {
            binding.userAvatar.setImageResource(R.drawable.hacker)
        }
        binding.okButton.setOnClickListener {
            val intent = Intent()
            if (intentGetExtra.equals(Constants.SIGN_UP_STATE)){
                intent.putExtra(Constants.LOGIN, binding.userLogin.text.toString())
                intent.putExtra(Constants.PASSWORD, binding.userPassword.text.toString())
                intent.putExtra(Constants.FIRST_NAME, binding.userFirstName.text.toString())
                intent.putExtra(Constants.SECOND_NAME, binding.userLastName.text.toString())
                intent.putExtra(Constants.AVATAR, R.drawable.hacker)
                Log.d("MY_LOG", binding.userAvatar.resources.toString())
                setResult(RESULT_OK, intent)
                finish()
            }else if (intentGetExtra.equals(Constants.SIGN_IN_STATE)){
                intent.putExtra(Constants.LOGIN, binding.userLogin.text.toString())
                intent.putExtra(Constants.PASSWORD, binding.userPassword.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}