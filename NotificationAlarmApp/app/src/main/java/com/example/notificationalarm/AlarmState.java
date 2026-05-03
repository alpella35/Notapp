package com.example.notificationalarm;

/**
 * Alarm durumunu takip eden basit sınıf
 * Android bağımlılığı olmadan test edilebilir
 */
public class AlarmState {
    private boolean isRunning = false;

    public void start() {
        this.isRunning = true;
    }

    public void stop() {
        this.isRunning = false;
    }

    public boolean isRunning() {
        return this.isRunning;
    }
}
