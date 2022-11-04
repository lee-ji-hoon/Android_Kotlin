package com.android.notification

import android.app.Notification
import android.app.Notification.BigTextStyle
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class CounterNotificationService(
    private val context: Context
) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(counter: Int) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )

        val incrementIntent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(context, CounterNotificationReceiver::class.java),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )

        val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_adb_24)
            .setContentTitle("알림 왔다.")
            .setContentText("${counter} 째 알람이다.")
            .setContentIntent(activityPendingIntent)
            .addAction(
                R.drawable.ic_baseline_adb_24,
                "Increment",
                incrementIntent
            )
            .build()
        notificationManager.notify(1, notification)
    }

    companion object {
        const val COUNTER_CHANNEL_ID = "counter_channel"
    }
}