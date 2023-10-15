package com.alif.uts_alif_rizqullah_maruf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Order_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Mengambil data yang dikirimkan dari Payment_Activity
        val bioskopText = intent.getStringExtra("BIOSKOP")
        val dateText = intent.getStringExtra("DATE")
        val jamTayangText = intent.getStringExtra("JAM_TAYANG")
        val seatText = intent.getStringExtra("SEAT")
        val paymentText = intent.getStringExtra("PAYMENT")

        // Menampilkan data di elemen-elemen UI di activity_order.xml
        val tempatFilm = findViewById<TextView>(R.id.tempat_film)
        tempatFilm.text = bioskopText

        val waktuFilm = findViewById<TextView>(R.id.waktu_film)
        waktuFilm.text = dateText

        val jamFilm = findViewById<TextView>(R.id.Jam_film)
        jamFilm.text = jamTayangText

        val seatTV = findViewById<TextView>(R.id.Seat_tv)
        seatTV.text = seatText

        val paySeatTV = findViewById<TextView>(R.id.Pay_Seat_tv)
        paySeatTV.text = paymentText

        val actualPayTV = findViewById<TextView>(R.id.Actual_Pay_tv)
        actualPayTV.text = paymentText
    }
}