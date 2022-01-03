import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.os3ketchup.yanvargi.MainActivity3
import com.os3ketchup.yanvargi.R

class AlarmReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent) {
        val i = Intent(context, MainActivity3::class.java)
        intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        val pendingIntent = PendingIntent.getActivities(context, 0, arrayOf(i), 0)

        val builder = NotificationCompat.Builder(context!!, "alarm")
            .setSmallIcon(R.drawable.ic_baseline_access_alarms_24)
            .setContentTitle(R.string.title.toString())
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        val notifi = NotificationManagerCompat.from(context)
        notifi.notify(123, builder.build())

    }

}