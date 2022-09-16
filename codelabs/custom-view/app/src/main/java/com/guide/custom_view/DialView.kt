package com.guide.custom_view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/09/16
 * @desc
 */

private const val RADIUS_OFFSET_LABEL = 30
private const val RADIUS_OFFSET_INDICATOR = -35

enum class FanSpeed(val label: Int) {
    OFF(R.string.fan_off),
    LOW(R.string.fan_low),
    MEDIUM(R.string.fan_medium),
    HIGH(R.string.fan_high);

    fun next() = when (this) {
        OFF -> LOW
        LOW -> MEDIUM
        MEDIUM -> HIGH
        HIGH -> OFF
    }
}

class DialView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var radius = 0.0f // 원의 반지름
    private var fanSpeed = FanSpeed.OFF // 기본값은 OFF
    private val pointPosition: PointF = PointF(0.0f, 0.0f) // 화면에 뷰의 여러 요소를 그리는데 사용되는 X Y 위치

    private var fanSpeedLowColor = 0
    private var fanSpeedMediumColor = 0
    private var fanSpeedMaxColor = 0
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.create("", Typeface.BOLD)
    }

    init {
        isClickable = true
        context.withStyledAttributes(attrs, R.styleable.DialView) {
            fanSpeedLowColor = getColor(R.styleable.DialView_fanColor1, 0)
            fanSpeedMediumColor = getColor(R.styleable.DialView_fanColor2, 0)
            fanSpeedMaxColor = getColor(R.styleable.DialView_fanColor3, 0)
        }
        updateContentDescription()
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true
        fanSpeed = fanSpeed.next()
        updateContentDescription()
        invalidate() // 뷰를 강제로 그리거나 다시 그리는데 사용된다.
        return true
    }

    // 레이아웃이 확장될 때, 처음으로 그려질 때를 포함하여 뷰의 크기가 변경될 때마다 호출이 된다.
    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        radius = (min(width, height) / 2.0 * 0.8).toFloat()
    }

    // 화면에 보기를 렌더링 하는 메서드를 재정의
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = when (fanSpeed) {
            FanSpeed.OFF -> Color.GRAY
            FanSpeed.LOW -> fanSpeedLowColor
            FanSpeed.MEDIUM -> fanSpeedMediumColor
            FanSpeed.HIGH -> fanSpeedMaxColor
        }

        // 다이얼 그리기
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, paint)
        val markerRadius = radius + RADIUS_OFFSET_INDICATOR
        pointPosition.computeXYForSpeed(fanSpeed, markerRadius)
        paint.color = Color.BLACK
        // 원형 그리기
        canvas.drawCircle(pointPosition.x, pointPosition.y, radius / 12, paint)
        val labelRadius = radius + RADIUS_OFFSET_LABEL
        // text 그리기
        for (i in FanSpeed.values()) {
            pointPosition.computeXYForSpeed(i, labelRadius)
            val label = resources.getString(i.label)
            canvas.drawText(label, pointPosition.x, pointPosition.y, paint)
        }
    }

    // label 또는 indicator 의 X,Y자표 계산하기
    // 라벨이 그려져야 하는 팬 속도 및 반지름이 주어지게 된다.
    private fun PointF.computeXYForSpeed(pos: FanSpeed, radius: Float) {
        val startAngle = Math.PI * (9 / 8.0)
        val angle = startAngle + pos.ordinal * (Math.PI / 4)
        x = (radius * cos(angle)).toFloat() + width / 2
        y = (radius * sin(angle)).toFloat() + height / 2
    }

    private fun updateContentDescription() {
        contentDescription = resources.getString(fanSpeed.label)
    }
}

