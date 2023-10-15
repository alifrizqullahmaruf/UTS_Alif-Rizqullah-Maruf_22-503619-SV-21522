package com.alif.uts_alif_rizqullah_maruf

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Detail_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val iconBack: ImageView = findViewById(R.id.icon_back)
        val getTicketButton: Button = findViewById(R.id.Get_ticket_button)

        iconBack.setOnClickListener {
            // Ketika icon_back diklik, buat Intent untuk kembali ke activity_home
            val intent = Intent(this, Home_Activity::class.java)
            startActivity(intent)
        }

        getTicketButton.setOnClickListener {
            // Ketika Get Ticket Button diklik, buat Intent untuk membuka activity_payment
            val intent = Intent(this, Payment_Activity::class.java)
            startActivity(intent)
        }
    }
}
