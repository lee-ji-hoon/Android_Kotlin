package com.android.rectangle_canvas

import android.graphics.Point
import android.graphics.PointF
import kotlin.math.*

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/09/23
 * @desc
 */

class Rectangle(
    val startPoint: PointF,
    var state: STATE = STATE.DRAWING
) {
    var end: PointF = startPoint

    val left: Float
        get() = min(startPoint.x, end.x)

    val right: Float
        get() = max(startPoint.x, end.x)

    val top: Float
        get() = min(startPoint.y, end.y)

    val bottom: Float
        get() = max(startPoint.y, end.y)

    enum class STATE{
        DRAWING,
        END
    }
}