package com.example.widgets.counter

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.balocco.photogallery.gallery.ui.CounterAdapter

private const val BOUNDS = 3

class CounterView : RecyclerView {

    private lateinit var counterAdapter: CounterAdapter
    private lateinit var layoutMngr: LinearLayoutManager
    private lateinit var smoothScroller: SmoothScroller

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    fun setup(start: Int, end: Int) {
        counterAdapter.updateItems(createList(start, end))
        smoothScroller.targetPosition = BOUNDS + 1
        layoutMngr.startSmoothScroll(smoothScroller)
    }

    fun reset() {
        layoutMngr.scrollToPosition(BOUNDS + 1)
        smoothScroller.targetPosition = BOUNDS + 1
        layoutMngr.startSmoothScroll(smoothScroller)
    }

    override fun onTouchEvent(motionEvent: MotionEvent?): Boolean {
        when (motionEvent?.action) {
            MotionEvent.ACTION_UP -> {
                scroll()
                performClick()
            }
        }
        return super.onTouchEvent(motionEvent)
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }

    private fun scroll() {
        smoothScroller.targetPosition = counterAdapter.itemCount - BOUNDS
        layoutMngr.startSmoothScroll(smoothScroller)
    }

    private fun init() {
        smoothScroller =
            CenteredSmoothScroller(context)
        layoutMngr = LinearLayoutManager(context)
        counterAdapter = CounterAdapter(context)

        setHasFixedSize(true)
        layoutManager = layoutMngr
        adapter = counterAdapter
    }

    private fun createList(start: Int, end: Int): List<Int> {
        val collection = mutableListOf<Int>()
        for (i in start - BOUNDS..end + BOUNDS) {
            collection.add(i)
        }
        return collection
    }
}