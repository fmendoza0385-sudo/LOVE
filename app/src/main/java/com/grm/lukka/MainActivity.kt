package com.grm.lukka

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(0xFF071426.toInt())
        }

        val title = TextView(this).apply {
            text = "LUKKA TELEVISIÓN"
            textSize = 28f
            setTextColor(0xFFFFFFFF.toInt())
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Tu reproductor IPTV. Agrega tu lista M3U para comenzar."
            textSize = 16f
            setTextColor(0xFFB8D7F5.toInt())
            gravity = Gravity.CENTER
            setPadding(0, 20, 0, 28)
        }

        val setup = Button(this).apply {
            text = "CONFIGURAR MI TELEVISIÓN"
            setOnClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "Asistente de listas M3U: pendiente de implementar.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        root.addView(title)
        root.addView(subtitle)
        root.addView(setup)
        setContentView(root)
    }
}
