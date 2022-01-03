package com.os3ketchup.yanvargi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.os3ketchup.yanvargi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


    }
}