package com.alif.uts_alif_rizqullah_maruf

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import android.app.DatePickerDialog
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Payment_Activity : AppCompatActivity() {
    private var selectedDate: Calendar = Calendar.getInstance()
    private lateinit var dateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val buttonPay = findViewById<Button>(R.id.Button_pay)
        buttonPay.setOnClickListener {
            // Mengambil data dari elemen-elemen UI
            val spinnerBioskop = findViewById<Spinner>(R.id.Pilih_bioskop_tv)
            val spinnerJamTayang = findViewById<Spinner>(R.id.Pilih_jam_tayang_tv)
            val spinnerSeat = findViewById<Spinner>(R.id.Pilih_seat_tv)
            val payment = findViewById<TextView>(R.id.payment)

            val selectedBioskop = spinnerBioskop.selectedItem.toString()
            val selectedDate = dateButton.text.toString()
            val selectedJamTayang = spinnerJamTayang.selectedItem.toString()
            val selectedSeat = spinnerSeat.selectedItem.toString()
            val selectedPayment = payment.text.toString()

            // Buat Intent untuk membuka activity_order dan kirimkan data melalui Intent
            val intent = Intent(this, Order_Activity::class.java)
            intent.putExtra("BIOSKOP", selectedBioskop)
            intent.putExtra("DATE", selectedDate)
            intent.putExtra("JAM_TAYANG", selectedJamTayang)
            intent.putExtra("SEAT", selectedSeat)
            intent.putExtra("PAYMENT", selectedPayment)
            startActivity(intent)
        }

        dateButton = findViewById(R.id.date)
        dateButton.setOnClickListener {
            showDatePicker()
        }

        // Di dalam onCreate
        val seatSelection = findViewById<TextView>(R.id.payment)
        val seatSpinner = findViewById<Spinner>(R.id.Pilih_seat_tv)
        seatSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = seatSpinner.selectedItem.toString()
                val paymentText = when (selectedItem) {
                    "Reguler" -> "Rp 35.000"
                    "Premium" -> "Rp 45.000"
                    "VIP" -> "Rp 55.000"
                    "VVIP" -> "Rp 65.000"
                    else -> "Rp 0"
                }
                seatSelection.text = paymentText
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle when nothing is selected (optional)
            }
        }

        // Inisialisasi Spinner
        val spinnerBioskop = findViewById<Spinner>(R.id.Pilih_bioskop_tv)
        val spinnerJamTayang = findViewById<Spinner>(R.id.Pilih_jam_tayang_tv)
        val spinnerPaymentMethod = findViewById<Spinner>(R.id.Payment_Method_tv)
        val spinnerBank = findViewById<Spinner>(R.id.spinnerPaymentMethod)

        // Mengambil data dari strings.xml
        val bioskopItems = resources.getStringArray(R.array.Bioskop)
        val seatItems = resources.getStringArray(R.array.Jenis_Seat)
        val jamTayangItems = resources.getStringArray(R.array.Pilih_jam_tayang)
        val paymentMethodItems = resources.getStringArray(R.array.Pay_method)
        val bankItems = resources.getStringArray(R.array.Bank)

        // Menghubungkan Spinner dengan adapter
        val bioskopAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, bioskopItems)
        val seatAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, seatItems)
        val jamTayangAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, jamTayangItems)
        val paymentMethodAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, paymentMethodItems)
        val bankAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, bankItems)

        // Mengatur tampilan Spinner
        bioskopAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        seatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        jamTayangAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        paymentMethodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        bankAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Menghubungkan adapter ke Spinner
        spinnerBioskop.adapter = bioskopAdapter
        seatSpinner.adapter = seatAdapter
        spinnerJamTayang.adapter = jamTayangAdapter
        spinnerPaymentMethod.adapter = paymentMethodAdapter
        spinnerBank.adapter = bankAdapter
    }

    private fun showDatePicker() {
        val year = selectedDate.get(Calendar.YEAR)
        val month = selectedDate.get(Calendar.MONTH)
        val day = selectedDate.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            // Ketika tanggal dipilih, simpan tanggal yang dipilih dalam variabel selectedDate
            selectedDate.set(year, monthOfYear, dayOfMonth)

            // Format tanggal yang dipilih (opsional, sesuaikan sesuai kebutuhan)
            val formattedDate = "${dayOfMonth}/${monthOfYear + 1}/${year}"
            dateButton.text = formattedDate
        }, year, month, day)

        // Menampilkan date picker dialog
        datePickerDialog.show()
    }
}
