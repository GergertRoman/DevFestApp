package ru.biatech.myapplication

import android.app.TabActivity
import android.content.Intent
import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private var toolbar: Toolbar? = null
    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()

        button = findViewById(R.id.bButton)
        button?.setOnClickListener {
            Toast.makeText(this, "Все доклады", Toast.LENGTH_LONG).show()
        }

    }


    private fun initToolbar() {
        toolbar = findViewById(R.id.toolbar)
        toolbar?.setTitle(R.string.app_name)
    }
}
