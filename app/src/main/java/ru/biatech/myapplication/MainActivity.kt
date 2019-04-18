package ru.biatech.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar?.setTitle(R.string.app_name)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        var adapter = ScheduleAdapter(generateData())
        val layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(rvSchedule?.context, layoutManager.orientation)
        rvSchedule?.addItemDecoration(dividerItemDecoration)
        rvSchedule?.layoutManager = layoutManager
        rvSchedule?.itemAnimator = DefaultItemAnimator()
        rvSchedule?.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun generateData(): ArrayList<InfoTopicDto> {
        var result = ArrayList<InfoTopicDto>()

        for (i in 0..14) {
            var array = resources.getStringArray(textArray[i])
            var report = array[3] != ""

            var topic = InfoTopicDto(
                time = array[0],
                theme = array[1],
                room = array[2],
                content = contentArray[i],
                language = languageArray[i],
                speaker = array[3],
                positionSpeaker = array[4],
                report = report
            )
            result.add(topic)
        }

        return result
    }
}
