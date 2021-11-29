package com.popov.myapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.popov.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var login: String = ""
    private var password: String = ""
    private var firstName: String = ""
    private var secondName: String = ""
    private var imageID: Int = 0

    private lateinit var launcherSignIn: ActivityResultLauncher<Intent?>
    private lateinit var launcherSignUp: ActivityResultLauncher<Intent?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launcherSignIn = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
            if (result.resultCode == RESULT_OK){
                val callback = result.data
            }
        }
        launcherSignUp = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
            if (result.resultCode == RESULT_OK){
                val callback = result.data
            }
        }

        binding.signIn.setOnClickListener {

        }
        binding.signUpAndClose.setOnClickListener {

        }
    }
}