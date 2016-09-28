package com.felight.javengers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

    }

    public void getNotification(View view)
    {
        Intent intent = new Intent(this, BenchMarkActivity.class);

        PendingIntent benchmarkIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        Notification noti =new  Notification.Builder(getBaseContext())
                .setContentTitle("BenchMarker")
                .setSmallIcon(R.drawable.common_google_signin_btn_icon_light)
                .setContentInfo("You'll be redirected to BenchMarker on clicking this")
                .addAction(R.drawable.common_google_signin_btn_icon_dark,"call", benchmarkIntent)
                .addAction(R.drawable.cast_ic_notification_small_icon,"more", benchmarkIntent)
                .setContentIntent(benchmarkIntent).build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        noti.flags |= Notification.FLAG_AUTO_CANCEL;
        manager.notify(0, noti);
    }
}
