package ru.biatech.myapplication

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.topic_item.view.*

class ScheduleAdapter(private var items: ArrayList<InfoTopicDto>): RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
            .inflate(R.layout.topic_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var infoTopicDto = items[position]
        infoTopicDto.time?.let { holder.time?.setText(it) }
        //holder?.time?.text = infoTopicDto.time
        infoTopicDto.theme?.let { holder.theme?.setText(it) }
        infoTopicDto.room?.let { holder.room?.setText(it) }
        infoTopicDto.content?.let { holder.content?.setImageResource(it) }
        infoTopicDto.language?.let { holder.language?.setImageResource(it) }
        if(infoTopicDto.report) {
            holder.content?.visibility = View.VISIBLE
            holder.language?.visibility = View.VISIBLE
            holder.itemView?.setOnClickListener {
                val ctx = holder.itemView.context
                val itemIntent = Intent(ctx, DesriptionRepportActivity::class.java)
                itemIntent.putExtra(ITEM_KEY, position)
                ctx.startActivity(itemIntent)
            }
        }
        else {
            holder.content?.visibility = View.INVISIBLE
            holder.language?.visibility = View.INVISIBLE
            holder.itemView?.isClickable = false
        }
        infoTopicDto.speaker?.let { holder.speaker?.setText(it) }
        infoTopicDto.positionSpeaker?.let { holder.positionSpeaker?.setText(it) }
    }

    class ViewHolder(row: View): RecyclerView.ViewHolder(row) {
        var time: TextView? = null
        var theme: TextView? = null
        var room: TextView? = null
        var content: ImageView? = null
        var language: ImageView? = null
        var speaker: TextView? = null
        var positionSpeaker: TextView? = null

        init {
            this.time = row?.tvTime
            this.theme = row?.tvTheme
            this.room = row?.tvRoom
            this.content = row?.ivContent
            this.language = row?.ivLanguage
            this.speaker = row?.tvSpeaker
            this.positionSpeaker = row?.tvPosition
        }

    }

}