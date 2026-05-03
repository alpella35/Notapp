package com.example.notificationalarm;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

public class AlarmController {
    
    private Context context;
    private Vibrator vibrator;
    private boolean isAlarmRunning = false;
    private static final long[] VIBRATION_PATTERN = {0, 500, 500, 500, 500, 500};
    private Thread alarmThread;

    public AlarmController(Context context) {
        this.context = context;
        this.vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void startAlarm() {
        if (isAlarmRunning) {
            return; // Alarm zaten çalışıyorsa başlatma
        }

        isAlarmRunning = true;
        
        alarmThread = new Thread(() -> {
            while (isAlarmRunning) {
                vibrate();
                try {
                    Thread.sleep(1000); // Her 1 saniye titreş
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        alarmThread.start();
    }

    public void stopAlarm() {
        isAlarmRunning = false;
        if (vibrator != null) {
            vibrator.cancel();
        }
        if (alarmThread != null) {
            try {
                alarmThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void vibrate() {
        if (vibrator != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                VibrationEffect effect = VibrationEffect.createWaveform(VIBRATION_PATTERN);
                vibrator.vibrate(effect);
            } else {
                vibrator.vibrate(VIBRATION_PATTERN, -1);
            }
        }
    }

    public boolean isAlarmRunning() {
        return isAlarmRunning;
    }
}
