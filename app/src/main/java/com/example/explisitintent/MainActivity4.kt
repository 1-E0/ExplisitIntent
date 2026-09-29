package com.example.explisitintent

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {

    companion object {
        const val dataPegawai = "kirimDataPegawai"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intentPegawai = IntentCompat.getParcelableArrayListExtra(intent, dataPegawai, Pegawai::class.java)

        val isiText = intentPegawai?.joinToString(separator = "\n\n") { pegawai ->
            "NIP : ${pegawai.NIP}\n" +
            "Nama : ${pegawai.Nama ?: "-"}\n" +
            "Dept : ${pegawai.Dept ?: "-"}"
        } ?: "-"

        val _showDataPegawai = findViewById<TextView>(R.id.showDataPegawai)
        _showDataPegawai.text = isiText
    }
}
