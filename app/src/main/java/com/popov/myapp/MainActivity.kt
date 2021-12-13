package com.popov.myapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.popov.myapp.constants.Constants
import com.popov.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var login: String = ""
    private var password: String = ""
    private var firstName: String = ""
    private var secondName: String = ""

    private lateinit var launcherSignIn: ActivityResultLauncher<Intent?>
    private lateinit var launcherSignUp: ActivityResultLauncher<Intent?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launcherSignUp = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
            if (result.resultCode == RESULT_OK){
                login = result.data?.getStringExtra(Constants.LOGIN).toString()
                firstName = result.data?.getStringExtra(Constants.FIRST_NAME).toString()
                secondName = result.data?.getStringExtra(Constants.SECOND_NAME).toString()
                result.data?.getIntExtra(Constants.AVATAR, 0)
                    ?.let { binding.userAvatar.setImageResource(it) }
                binding.userAvatar.visibility = View.VISIBLE

                Log.d("MY_LOG", login)

                val textInfo = "Welcome new user! \n Your login: $login \n First name: " +
                        "$firstName \n Second name: $secondName"
                binding.tvInfo.text = textInfo
                binding.signUp.visibility = View.INVISIBLE
                binding.signIn.text = getString(R.string.exit_button)
            }
        }
        launcherSignIn = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result: ActivityResult ->
            if (result.resultCode == RESULT_OK){
                login = result.data?.getStringExtra(Constants.LOGIN).toString()
                password = result.data?.getStringExtra(Constants.PASSWORD).toString()
                Log.d("MY_LOG", login)
                Log.d("MY_LOG", password)

                if (login == "Bob" && password == "123"){
                    val textInfo = "Welcome home: $login"
                    binding.tvInfo.text = textInfo
                    binding.userAvatar.visibility = View.VISIBLE
                    binding.userAvatar.setImageResource(R.drawable.construction_worker)
                    binding.signUp.visibility = View.INVISIBLE
                    binding.signIn.text = getString(R.string.exit_button)
                }else{
                    binding.userAvatar.visibility = View.VISIBLE
                    binding.tvInfo.text = getString(R.string.tv_info)
                    binding.userAvatar.setImageResource(R.drawable.warning)
                    binding.signUp.visibility = View.INVISIBLE
                    binding.signIn.text = getString(R.string.exit_button)
                }
            }
        }

        binding.signIn.setOnClickListener {
            if (binding.userAvatar.visibility == View.VISIBLE &&
                binding.tvInfo.text.toString() != ""){
                binding.signIn.text = getString(R.string.sign_in)
                binding.signUp.visibility = View.VISIBLE
                binding.userAvatar.visibility = View.INVISIBLE
                binding.tvInfo.text = ""
            }else{
                launcherSignIn.launch(setIntent(this, SignInUpActivity::class.java,
                    Constants.SIGN_IN_STATE))
            }
        }
        binding.signUp.setOnClickListener {
            launcherSignUp.launch(setIntent(this, SignInUpActivity::class.java,
                Constants.SIGN_UP_STATE))
        }
    }
}