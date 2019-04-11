package ru.biatech.myapplication
import android.content.Intent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar?.setTitle(R.string.app_name)

        content()

        bButton?.setOnClickListener {
            Toast.makeText(this, R.string.buttonText, Toast.LENGTH_LONG).show()
        }

        tvSpeaker?.setOnClickListener {
            val speakerIntent = Intent(this@MainActivity, SpeakerActivity::class.java)
            speakerIntent.putExtra(ACTIVITY_KEY, Tag.MINE.name)
            startActivity(speakerIntent)
        }
    }

    private fun content() {
        tvTime?.setText(R.string.time)

        tvTheme?.setText(R.string.theme)

        tvRoom?.setText(R.string.room)

        ivContent?.setImageResource(R.drawable.android_head)

        ivLanguage?.setImageResource(R.drawable.ic_rus)

        tvSpeaker?.setText(R.string.speaker)

        tvSpeaker?.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))

        tvPosition?.setText(R.string.position_speaker)

        tvDescription?.setText(R.string.description)
    }
}
