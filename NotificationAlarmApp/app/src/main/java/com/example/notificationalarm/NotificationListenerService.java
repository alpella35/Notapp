package com.example.notificationalarm;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Vibrator;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

public class NotificationListenerService extends NotificationListenerService {
    
    private static final String PREFS_NAME = "AlarmSettings";
    private static final String KEYWORDS_KEY = "keywords";
    private static final String STOP_KEYWORD_KEY = "stop_keyword";
    
    private SharedPreferences prefs;
    private AlarmController alarmController;

    @Override
    public void onCreate() {
        super.onCreate();
        prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        alarmController = new AlarmController(this);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);
        
        if (sbn == null) return;
        
        String tickerText = "";
        if (sbn.getNotification() != null && sbn.getNotification().tickerText != null) {
            tickerText = sbn.getNotification().tickerText.toString();
        }
        
        String keywordsStr = prefs.getString(KEYWORDS_KEY, "");
        String stopKeyword = prefs.getString(STOP_KEYWORD_KEY, "");
        
        // Durma kelimesi kontrol et
        if (!stopKeyword.isEmpty() && tickerText.toLowerCase().contains(stopKeyword.toLowerCase())) {
            alarmController.stopAlarm();
            return;
        }
        
        // Anahtar kelimeleri kontrol et
        if (!keywordsStr.isEmpty()) {
            String[] keywords = keywordsStr.split(",");
            for (String keyword : keywords) {
                keyword = keyword.trim();
                if (!keyword.isEmpty() && tickerText.toLowerCase().contains(keyword.toLowerCase())) {
                    alarmController.startAlarm();
                    break;
                }
            }
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        super.onNotificationRemoved(sbn);
    }
}
