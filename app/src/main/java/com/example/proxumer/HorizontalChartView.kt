package com.example.newbaseandroid.proxumer

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.graphics.DashPathEffect
import android.graphics.PathEffect
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.proxumer.R


class HorizontalChartView  @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private lateinit var valueAnimator: ValueAnimator
    private var paint = Paint()
    private var paintCenter = Paint()
    private var paintShadow = Paint()
    private var paintShadowCenter = Paint()
    var radius = 8f
    var color = R.color.color_orange
    var colorBorder = R.color.color_dark_grey
    var percent = 0f
    private  var chartSize: Float = 0f

    @SuppressLint("DrawAllocation")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onDraw(canvas: Canvas?)
    {
        super.onDraw(canvas)

        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL

        paintShadow.isAntiAlias = true
        paintShadow.style = Paint.Style.FILL

        paint.color = context.getColor(color)
        paintCenter.color = context.getColor(color)
        paintShadow.color = context.getColor(colorBorder)
        paintShadowCenter.color = context.getColor(colorBorder)

        canvas?.let {

            //start at [left, top] 0
            val borderRect = RectF(0f,0f,width.toFloat(),height.toFloat())

            it.drawRoundRect(borderRect , radius, radius, paintShadow)
            var mCurrentRect = RectF(0f,0f,chartSize,height.toFloat())
            if (percent < 1){
                mCurrentRect = RectF(0f, radius/2, chartSize,height.toFloat() - (radius/2))
            }
            it.drawRoundRect(mCurrentRect , radius, radius, paint)

        }
    }




    fun startAnimation(animatorDuration: Long = 2000) {
        if (::valueAnimator.isInitialized) {
            // Clear last animate.
            valueAnimator.cancel()
        }

        valueAnimator = ValueAnimator.ofFloat(0f, 1f)
        valueAnimator.duration = animatorDuration
        valueAnimator.addUpdateListener {
            chartSize = (((percent*width)/100) * (it.animatedValue as Float))
            invalidate()
        }
        valueAnimator.start()
    }

}