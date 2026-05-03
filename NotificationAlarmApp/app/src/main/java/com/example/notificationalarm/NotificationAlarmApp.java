package com.example.notificationalarm;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Vibrator;

public class NotificationAlarmApp extends Application {
    
    private static NotificationAlarmApp instance;
    public static NotificationAlarmApp getInstance() {
        return instance;
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
