package com.example.aprovaai.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log

class StudyReminderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("StudyReminderReceiver", "Recebido o alarme de estudo")
        val contentText = intent.getStringExtra("CONTENT_TEXT")
        Log.d("StudyReminderReceiver", "Conteúdo da notificação: $contentText")

        val serviceIntent = Intent(context, NotificationService::class.java).apply {
            putExtra("CONTENT_TEXT", contentText)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(serviceIntent)
        } else {
            context.startService(serviceIntent)
        }
    }
}
