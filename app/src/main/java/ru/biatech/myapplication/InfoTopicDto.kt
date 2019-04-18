package ru.biatech.myapplication

import android.graphics.drawable.Drawable
import android.widget.ImageView

class InfoTopicDto {
    var time: String = ""
    var theme: String = ""
    var room: String = ""
    var content: Int? = null
    var language: Int? = null
    var speaker: String = ""
    var positionSpeaker: String = ""
    var report: Boolean = true

    constructor() {}

    constructor(time: String, theme: String, room: String, content: Int, language: Int, speaker: String,
                positionSpeaker: String, report: Boolean) {
        this.time = time
        this.theme = theme
        this.room = room
        this.content = content
        this.language = language
        this.speaker = speaker
        this.positionSpeaker = positionSpeaker
        this.report = report
    }
}