package com.alif.uts_alif_rizqullah_maruf

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Home_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val imgFilm3: ImageView = findViewById(R.id.img_film_3)

        imgFilm3.setOnClickListener {
            // Ketika img_film_3 diklik, buat Intent untuk membuka activity_detail
            val intent = Intent(this, Detail_Activity::class.java)
            startActivity(intent)
        }
    }
}
