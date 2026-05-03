package com.example.notificationalarm;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    private EditText keywordsInput;
    private EditText stopKeywordInput;
    private Button saveButton;
    private Button stopAlarmButton;
    private SharedPreferences prefs;
    private AlarmController alarmController;
    
    private static final String PREFS_NAME = "AlarmSettings";
    private static final String KEYWORDS_KEY = "keywords";
    private static final String STOP_KEYWORD_KEY = "stop_keyword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        alarmController = new AlarmController(this);
        
        keywordsInput = findViewById(R.id.keywords_input);
        stopKeywordInput = findViewById(R.id.stop_keyword_input);
        saveButton = findViewById(R.id.save_button);
        stopAlarmButton = findViewById(R.id.stop_alarm_button);
        
        // Kaydedilen ayarları yükle
        loadSettings();
        
        // Kaydet butonu
        saveButton.setOnClickListener(v -> saveSettings());
        
        // Alarmu durdur butonu
        stopAlarmButton.setOnClickListener(v -> {
            alarmController.stopAlarm();
            Toast.makeText(MainActivity.this, "Alarm durduruldu", Toast.LENGTH_SHORT).show();
        });
    }
    
    private void saveSettings() {
        String keywords = keywordsInput.getText().toString().trim();
        String stopKeyword = stopKeywordInput.getText().toString().trim();
        
        if (keywords.isEmpty()) {
            Toast.makeText(this, "Lütfen kancı kelime girin", Toast.LENGTH_SHORT).show();
            return;
        }
        
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEYWORDS_KEY, keywords);
        editor.putString(STOP_KEYWORD_KEY, stopKeyword);
        editor.apply();
        
        Toast.makeText(this, "Ayarlar kaydedildi", Toast.LENGTH_SHORT).show();
    }
    
    private void loadSettings() {
        String keywords = prefs.getString(KEYWORDS_KEY, "");
        String stopKeyword = prefs.getString(STOP_KEYWORD_KEY, "");
        
        keywordsInput.setText(keywords);
        stopKeywordInput.setText(stopKeyword);
    }
}
