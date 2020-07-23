package com.example.widgets.gradient

import android.animation.*
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

private const val GRADIENT_ANIMATION_DURATION_MS = 3000L
private const val COLOR_BOTTOM_ONE = Color.RED
private const val COLOR_TOP_ONE = Color.BLUE
private const val COLOR_BOTTOM_TWO = Color.GREEN
private const val COLOR_TOP_TWO = Color.YELLOW

class GradientImageView : AppCompatImageView {

    private lateinit var gradientDrawable: GradientDrawable
    private var animator: ValueAnimator? = null

    private var startColorBottom = COLOR_BOTTOM_ONE
    private var endColorBottom = COLOR_BOTTOM_TWO
    private var startColorTop = COLOR_TOP_ONE
    private var endColorTop = COLOR_TOP_TWO

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    fun startAnimation() {
        if (animator != null && animator!!.isRunning) {
            return
        }

        val evaluator = ArgbEvaluator()
        animator = TimeAnimator.ofFloat(0.0f, 1.0f)
        animator?.apply {
            duration =
                GRADIENT_ANIMATION_DURATION_MS
            addUpdateListener {
                val fraction = it.animatedFraction
                val newStart = evaluator.evaluate(fraction, startColorBottom, endColorBottom) as Int
                val newEnd = evaluator.evaluate(fraction, startColorTop, endColorTop) as Int

                gradientDrawable.colors = intArrayOf(newStart, newEnd)
            }
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    if (startColorTop == COLOR_TOP_ONE) {
                        startColorTop =
                            COLOR_TOP_TWO
                        startColorBottom =
                            COLOR_BOTTOM_TWO
                        endColorTop = COLOR_TOP_ONE
                        endColorBottom =
                            COLOR_BOTTOM_ONE
                    } else {
                        startColorTop =
                            COLOR_TOP_ONE
                        startColorBottom =
                            COLOR_BOTTOM_ONE
                        endColorTop = COLOR_TOP_TWO
                        endColorBottom =
                            COLOR_BOTTOM_TWO
                    }
                }
            })
            start()
        }
    }

    fun stopAnimation() {
        animator?.apply {
            removeAllListeners()
            cancel()
        }
        animator = null
    }

    private fun init() {
        gradientDrawable = GradientDrawable(
            GradientDrawable.Orientation.BOTTOM_TOP,
            intArrayOf(startColorBottom, startColorTop)
        )
        setImageDrawable(gradientDrawable)
    }
}