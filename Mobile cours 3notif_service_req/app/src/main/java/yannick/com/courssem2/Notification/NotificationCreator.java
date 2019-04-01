package yannick.com.courssem2.Notification;

import android.app.Notification;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import yannick.com.courssem2.Notification.Model.MessageModel;
import yannick.com.courssem2.R;

public class NotificationCreator {
    public static Notification createNotificationForMessage(Context context, MessageModel message){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "42")
                .setSmallIcon(R.drawable.bed)
                .setContentTitle(message.getSender())
                .setContentText(message.getMessage())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return builder.build();
    }
}
