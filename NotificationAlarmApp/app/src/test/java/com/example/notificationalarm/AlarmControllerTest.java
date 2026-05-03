package com.example.notificationalarm;

import org.junit.Test;
import static org.junit.Assert.*;

public class AlarmControllerTest {

    /**
     * Alarm başlatma ve durdurma fonksiyonalitesini test et
     */
    @Test
    public void testAlarmStateToggle() {
        // Alarm durumunu kontrol et
        AlarmState state = new AlarmState();
        
        assertFalse("Alarm başlangıçta kapalı olmalı", state.isRunning());
        
        state.start();
        assertTrue("Alarm açıldıktan sonra çalışıyor olmalı", state.isRunning());
        
        state.stop();
        assertFalse("Alarm kapatıldıktan sonra durmalı", state.isRunning());
    }

    @Test
    public void testAlarmNotStartingTwice() {
        AlarmState state = new AlarmState();
        
        state.start();
        assertTrue(state.isRunning());
        
        // İkinci kez başlatmaya çalış (tekrar başlatmamalı)
        state.start();
        assertTrue("Alarm çalışmaya devam etmeli", state.isRunning());
    }

    @Test
    public void testAlarmStoppingWhenNotRunning() {
        AlarmState state = new AlarmState();
        assertFalse("Alarm başlangıçta kapalı olmalı", state.isRunning());
        
        // Durmayan alarmu durdurmeye çalış
        state.stop();
        assertFalse("Alarm kapalı kalmalı", state.isRunning());
    }

    @Test
    public void testMultipleStartStop() {
        AlarmState state = new AlarmState();
        
        for (int i = 0; i < 3; i++) {
            state.start();
            assertTrue("Döngü " + i + ": Alarm açık olmalı", state.isRunning());
            
            state.stop();
            assertFalse("Döngü " + i + ": Alarm kapalı olmalı", state.isRunning());
        }
    }
}

