package ru.biatech.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import kotlinx.android.synthetic.main.description_report.*
import kotlinx.android.synthetic.main.toolbar.*

class DesriptionRepportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.description_report)

        val tag = intent.getStringExtra(ACTIVITY_KEY)
        val tagRv = intent.getIntExtra(ITEM_KEY, 1)

        toolbar?.setTitle(R.string.app_name)

        content(tagRv)

        bButton?.setOnClickListener {
            val speakerIntent = Intent(this@DesriptionRepportActivity, MainActivity::class.java)
            speakerIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(speakerIntent)
        }

        if(tag == Tag.SPEAKER.name) {
            tvSpeaker?.setOnClickListener {
                val speakerIntent = Intent(this@DesriptionRepportActivity, SpeakerActivity::class.java)
                speakerIntent.putExtra(ITEM_KEY, tagRv)
                speakerIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(speakerIntent)
            }
        } else {
            tvSpeaker?.setOnClickListener {
                val speakerIntent = Intent(this@DesriptionRepportActivity, SpeakerActivity::class.java)
                speakerIntent.apply {
                    putExtra(ITEM_KEY, tagRv)
                }
                startActivity(speakerIntent)
            }
        }
    }

    private fun content(tag: Int) {
        var array = resources.getStringArray(textArray[tag])
        tvTime?.text = array[0]

        tvTheme?.text = array[1]

        tvRoom?.text = array[2]

        ivContent?.setImageResource(contentArray[tag])

        ivLanguage?.setImageResource(languageArray[tag])

        tvSpeaker?.text = array[3]

        tvPosition?.text = array[4]

        tvDescription?.text = array[5]
        tvDescription?.movementMethod = ScrollingMovementMethod()
    }
}