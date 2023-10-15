package com.alif.uts_alif_rizqullah_maruf


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alif.uts_alif_rizqullah_maruf.databinding.ActivityLoginBinding

class Login_Activity : AppCompatActivity() {

    private val TAG = "MainActivityLifecycle"
    private lateinit var binding: ActivityLoginBinding

    companion object {
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            val usernameText = binding.username2.text.toString()
            val password = binding.password2.text.toString()
            if (checkCredentials(usernameText, password)) { // Check credentials
                val intent = Intent(this@Login_Activity, Home_Activity::class.java)
                intent.putExtra(EXTRA_NAME, usernameText)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(
                    this@Login_Activity,
                    "Invalid username or password, please check the input.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Tambahkan tindakan klik untuk ikon insta
        binding.instaIcon.setOnClickListener {
            val githubUrl = "https://instagram.com/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl))
            startActivity(intent)
        }

        // Tambahkan tindakan klik untuk ikon Google
        binding.googleIcon.setOnClickListener {
            val googleUrl = "https://www.google.com/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(googleUrl))
            startActivity(intent)
        }

        // Tambahkan tindakan klik untuk ikon Facebook
        binding.facebookIcon.setOnClickListener {
            val facebookUrl = "https://id-id.facebook.com/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl))
            startActivity(intent)
        }
    }

    private fun checkCredentials(usernameText: String, password: String): Boolean {
        val userCredentials = listOf(
            Pair("Alif", "123"),
            Pair("Muje", "321")
        )
        for ((storedUsername, storedPassword) in userCredentials) {
            if (usernameText == storedUsername && password == storedPassword) {
                return true
            }
        }
        return false
    }
}