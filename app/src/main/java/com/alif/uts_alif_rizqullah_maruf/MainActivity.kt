package com.alif.uts_alif_rizqullah_maruf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alif.uts_alif_rizqullah_maruf.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            parent.setOnClickListener{
                val intent = Intent(this@MainActivity,Login_Activity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }



}