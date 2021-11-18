package com.popov.myapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.popov.myapp.databinding.ActivityTestBinding

class Test : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val message = "Intent message: " + intent.getStringExtra("key")

        binding.textView2.text = message

        binding.button4.setOnClickListener {
            intent.putExtra("key", binding.editText.text)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}