package ru.biatech.myapplication

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_speaker.*
import kotlinx.android.synthetic.main.toolbar.*

class SpeakerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speaker)

        toolbar?.setTitle(R.string.app_name)

        content()

        callScreen()

        ivTelegram?.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.telegram_ryabov))))
        }

        ivTwitter?.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.twitter_ryabov))))
        }
    }

    private fun content() {
        civAvatar?.setImageResource(R.drawable.sergey_ryabov)

        ivLanguage?.setImageResource(R.drawable.ic_rus)

        tvSpeaker?.setText(R.string.speaker)
        tvSpeaker?.setTextColor(Color.BLACK)

        tvPosition?.setText(R.string.position_speaker)

        tvInfoSpeaker?.setText(R.string.info_about_speaker)

        tvTheme?.setText(R.string.theme)

        tvRoom?.setText(R.string.room)

        ivContent?.setImageResource(R.drawable.android_head)

        tvTime?.setText(R.string.time)
    }

    private fun callScreen() {
        val tag = intent.getStringExtra(ACTIVITY_KEY)
        if(tag == Tag.MINE.name) {
            tvTheme?.setOnClickListener {
                onBackPressed()
            }
        }
    }
}
