package com.dkin.chevit.presentation.notification

import android.Manifest.permission.POST_NOTIFICATIONS
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.repository.NotificationRepository
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import timber.log.Timber
import javax.inject.Inject
import com.dkin.chevit.presentation.resource.R as ChevitResource

@AndroidEntryPoint
class ChevitFirebaseMessagingService : FirebaseMessagingService() {
    @Inject
    lateinit var notificationRepository: NotificationRepository

    @Inject
    lateinit var dispatcher: CoroutineDispatcherProvider

    private val notificationManagerCompat: NotificationManagerCompat by lazy {
        NotificationManagerCompat.from(this)
    }

    private val processLifecycleScope by lazy {
        ProcessLifecycleOwner.get().lifecycleScope
    }

    private val coroutineScope by lazy {
        processLifecycleScope + dispatcher.io + CoroutineExceptionHandler { _, exception ->
            Timber.d(exception)
        }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        coroutineScope.launch() {
            notificationRepository.updatePushToken(token)
        }
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        if (hasNotificationChannel().not()) {
            createNotificationChannel()
        }
        if (ActivityCompat.checkSelfPermission(this, POST_NOTIFICATIONS) == PERMISSION_GRANTED) {
            notificationManagerCompat.notify(message.hashCode(), message.toNotification())
        }
    }

    private fun RemoteMessage.toNotification(): Notification {
        val notification =
            NotificationCompat.Builder(this@ChevitFirebaseMessagingService, "default")
                .setColor(
                    ContextCompat.getColor(
                        this@ChevitFirebaseMessagingService,
                        ChevitResource.color.blue_7
                    )
                )
                .setSmallIcon(ChevitResource.drawable.ic_notification_logo)
                .setContentTitle(notification?.title)
                .setContentText(notification?.body)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build()
        return notification
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            "default",
            "알림 기본 채널",
            NotificationManager.IMPORTANCE_HIGH
        )
        notificationManagerCompat.createNotificationChannel(channel)
    }

    private fun hasNotificationChannel(): Boolean {
        return notificationManagerCompat.getNotificationChannel("default") != null
    }
}
