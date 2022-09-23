package com.android.rectangle_canvas

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/09/23
 * @desc
 */

class RectangleDrawingCanvas(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {
    private var currentBox: Rectangle? = null
    private var boxen = mutableListOf<Rectangle>()
    private val drawingPaint = Paint().apply {
        color = Color.RED
        alpha = 25
    }
    private val endPaint = Paint().apply {
        color = Color.RED
        alpha = 100
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val currentPoint = PointF(event.x, event.y)
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                currentBox = Rectangle(currentPoint).also { boxen.add(it) }
            }
            MotionEvent.ACTION_MOVE -> {
                updateCurrentBox(currentPoint, false)
            }
            MotionEvent.ACTION_UP -> {
                updateCurrentBox(currentPoint, true)
                currentBox = null
            }
        }
        return true
    }

    private fun updateCurrentBox(current: PointF, endDrawing: Boolean) {
        currentBox?.let {
            it.end = current
            if (endDrawing) {
                it.state = Rectangle.STATE.END
            }
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas) {
        boxen.forEach { box ->
            if (box.state == Rectangle.STATE.END) canvas.drawRect(box.left, box.top, box.right, box.bottom, endPaint)
            else canvas.drawRect(box.left, box.top, box.right, box.bottom, drawingPaint)
        }
    }
}