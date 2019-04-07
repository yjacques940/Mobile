package yannick.com.courssem2.Notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class NotificationService {

    private void createNotificationChannel()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String channelID = "42";
            CharSequence channelName = "yannick.notif.yj";
            String channelDescription = "Notifications de yannick";
            int channelImportance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelID,channelName,channelImportance);
            channel.setDescription(channelDescription);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
