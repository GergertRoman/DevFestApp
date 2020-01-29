package ru.biatech.myapplication

import android.support.v7.widget.RecyclerView
import android.view.View

class CustomLayoutManager (
    private val maxItemCount: Int
) : RecyclerView.LayoutManager() {
    private val addedChildren: List<View>
        get() = (0 until childCount).map { getChildAt(it) ?: throw NullPointerException() }

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams =
        RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.MATCH_PARENT)

    override fun isAutoMeasureEnabled(): Boolean = true

    override fun onLayoutChildren(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State
    ) {
        if (state.itemCount == 0) {
            return
        }
        if (state.itemCount > maxItemCount) {
            throw RuntimeException("Can not set more Item than maxItemCount")
        }

        detachAndScrapAttachedViews(recycler)

        for (i in 0 until state.itemCount) {
            val view = recycler.getViewForPosition(i)
            measureChild(view, 0, 0)
            addView(view)
            val layoutParams = view.layoutParams as RecyclerView.LayoutParams
            val left = layoutParams.marginStart
            val top = (view.measuredHeight * i * 1.2).toInt()
            val deftop = (view.measuredHeight * i * 0.35).toInt()
            val right = view.measuredWidth + layoutParams.marginEnd
            val bottom = deftop + view.measuredHeight
            layoutDecorated(view, left, deftop, right, bottom)
            view.setTag(InitializedPosition.DEFAULT.key, deftop)
            view.setTag(InitializedPosition.TOP.key, top)
        }
    }

    override fun canScrollVertically(): Boolean = true

    override fun scrollVerticallyBy(
        dy: Int,
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State
    ): Int = dy.also { deltaY ->
        if (childCount == 0) {
            return@also
        }

        addedChildren.forEachIndexed { index, view ->
            val defTop = view.getTag(InitializedPosition.DEFAULT.key) as Int
            val absolutTop = view.getTag(InitializedPosition.TOP.key) as Int
            val layoutParams = view.layoutParams as RecyclerView.LayoutParams
            val left = layoutParams.marginStart
            val max = Math.max((view.top - deltaY), index * 10)
            var top = 0
            if(deltaY < 0) {
                top = Math.min((view.top - deltaY * index), absolutTop)//index * 400
            } else {
                top = Math.min(defTop, max)//Math.min(initializedTop, max)
            }
            val right = view.measuredWidth + layoutParams.marginEnd
            val bottom = top + view.measuredHeight
            layoutDecorated(view, left, top, right, bottom)
        }
    }

    private enum class InitializedPosition(val key: Int) {
        DEFAULT(R.integer.def),
        TOP(R.integer.top)
    }
}