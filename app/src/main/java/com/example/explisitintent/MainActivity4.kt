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


        val isiText : String ="NIP : ${intentPegawai?.get(0)?.NIP.toString()}, " +
                "\n Nama : ${intentPegawai?.get(0)?.Nama.toString()}, " +
                "\n Dept : ${intentPegawai?.get(0)?.Dept.toString()}" +
                "\n  " +
                "\n NIP : ${intentPegawai?.get(1)?.NIP.toString()}, " +
                "\n Nama : ${intentPegawai?.get(1)?.Nama.toString()}, " +
                "\n Dept : ${intentPegawai?.get(1)?.Dept.toString()}"



        val _showDataPegawai = findViewById<TextView>(R.id.showDataPegawai)
        _showDataPegawai.text = isiText
    }
}
