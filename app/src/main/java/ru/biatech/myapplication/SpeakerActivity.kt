package ru.biatech.myapplication

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import kotlinx.android.synthetic.main.activity_speaker.*
import kotlinx.android.synthetic.main.toolbar.*

class SpeakerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speaker)
        val tagRv = intent.getIntExtra(ITEM_KEY, 1)
        toolbar?.setTitle(R.string.app_name)

        bindContent(tagRv)

        callScreen(tagRv)
    }

    private fun bindContent(tag: Int) {
        var array = resources.getStringArray(textArray[tag])

        civAvatar?.setImageResource(photosArray[tag])

        ivLanguage?.setImageResource(languageArray[tag])

        tvSpeaker?.text = array[3]

        tvPosition?.text = array[4]

        tvInfoSpeaker?.text = array[6]
        tvInfoSpeaker?.movementMethod = ScrollingMovementMethod()

        tvTheme?.text = array[1]

        tvRoom?.text = array[2]

        ivContent?.setImageResource(contentArray[tag])

        tvTime?.text = array[0]

        if(array[7] != "") {
            ivTelegram?.apply {
                setImageResource(R.drawable.ic_telegram)
                setOnClickListener {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(array[7])))
                }
            }
            if(array[9] != "") {
                ivTwitter?.apply {
                    setImageResource(R.drawable.ic_twitter)
                    setOnClickListener {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(array[9])))
                    }
                }

            }  else
                if(array[8] != "") {
                    ivTwitter?.apply {
                        setImageResource(R.drawable.ic_link_variant)
                        setOnClickListener {
                            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(array[8])))
                        }
                    }
                }
        } else
            if(array[9] != "") {
                ivTelegram?.apply {
                    setImageResource(R.drawable.ic_twitter)
                    setOnClickListener {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(array[9])))
                    }
                }
                if(array[8] != "") {
                    ivTwitter?.apply {
                        setImageResource(R.drawable.ic_link_variant)
                        setOnClickListener {
                            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(array[8])))
                        }
                    }
                }
            } else
                if(array[8] != "") {
                    ivTelegram?.apply {
                        setImageResource(R.drawable.ic_link_variant)
                        setOnClickListener {
                            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(array[8])))
                        }
                    }
                }
    }

    private fun callScreen(tag: Int) {
        //val tag = intent.getStringExtra(ACTIVITY_KEY)
        //val tagRv = intent.getIntExtra(ITEM_KEY, 1)
        /*if(tag == Tag.MINE.name) {
            tvTheme?.setOnClickListener {
                onBackPressed()
            }
        }
        else {*/
            tvTheme?.setOnClickListener {
                val speakerIntent = Intent(this@SpeakerActivity, DesriptionRepportActivity::class.java)
                speakerIntent.apply {
                    putExtra(ITEM_KEY, tag)
                    speakerIntent.putExtra(ACTIVITY_KEY, Tag.SPEAKER.name)
                }
                startActivity(speakerIntent)
            //}
        }
    }
}
