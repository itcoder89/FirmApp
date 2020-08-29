package fcm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.kodpartner.DashboardActivity;
import com.kodpartner.R;


public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public static final String NOTIF_CHANNEL_ID = "my_channel_01";
    @Override
    public void onMessageReceived(RemoteMessage message) {
        Log.e("message","title: "+message.getNotification().getTitle());
        Log.e("message","body: "+message.getNotification().getBody());
        Log.e("message","sound: "+message.getNotification().getSound());
        playNotificationSound(this);
        sendMyNotification(message.getNotification().getTitle(),message.getNotification().getBody(),true);
    }


    public void playNotificationSound(Context context) {
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(context, notification);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private void createNotifChannel(Context context) {
        NotificationChannel channel = new NotificationChannel(NOTIF_CHANNEL_ID,
                "MyApp events", NotificationManager.IMPORTANCE_LOW);
        // Configure the notification channel
        channel.setDescription("MyApp event controls");
        channel.setShowBadge(false);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

        NotificationManager manager = context.getSystemService(NotificationManager.class);

        manager.createNotificationChannel(channel);
        //Log.e("dfdf", "createNotifChannel: created=" + NOTIF_CHANNEL_ID);
    }


    private void sendMyNotification(String title, String message, boolean silent) {

        //On click of notification it redirect to this Activity
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotifChannel(this);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (notificationManager.getNotificationChannel(NOTIF_CHANNEL_ID) == null) {
                createNotifChannel(this);
            }
        }


        Intent intent = new Intent(this, DashboardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri soundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIF_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                //.setLargeIcon(BitmapFactory.decodeResource(congetResources(), R.drawable.custom_logo))
                .setContentTitle(title)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setContentIntent(pendingIntent);
        Log.e("silent", "value: "+silent);
        //if(!silent)
            notificationBuilder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));


        notificationManager.notify(1, notificationBuilder.build());
    }
}
