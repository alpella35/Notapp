# Bildirim Tabanlı Titreş Alarm Uygulaması

Bu Android uygulaması, belirli anahtar kelimeleri içeren bildirimleri dinler ve titreşli alarm başlatır.

## Özellikler

✅ **Bildirim Dinleyici** - Gelen tüm bildirimleri takip eder  
✅ **Anahtar Kelime Tespiti** - Belirtilen kelimeleri tespit ederse alarm başlar  
✅ **Titreş Alarmı** - Telefon sürekli titreşir  
✅ **Durma Kelimesi** - Özel kelime gördüğünde alarm otomatik durur  
✅ **Manuel Kontrol** - Alarmu manuel olarak da durdurabilirsiniz  

## Kurulum

1. **Android Studio'da aç**: `NotificationAlarmApp` klasörünü aç
2. **Gradle senkronizasyonu**: Gradle dosyaları otomatik olarak sinkronize olacak
3. **Uygulamayı derle ve çalıştır**: `./gradlew build` ve `./gradlew installDebug`

## İzinler

Uygulamayı kullanmak için aşağıdaki izinler gereklidir:

- **Bildirim Erişimi**: Ayarlar → Uygulamalar → Özel Uygulama Erişimi → Bildirim Erişimi
- **Titreş İzni**: Otomatik verilir
- **Bildirim Gönderme**: Android 13+ cihazlarda gereklidir

## Nasıl Kullanılır

1. **Uygulamayı Aç**
   - Anahtar kelimeler gir (örn: "acil, uyarı, hassas")
   - Alarm durma kelimesi gir (örn: "tamam, çöz")
   - "Ayarları Kaydet" butonuna tıkla

2. **Uygulamaya Bildirim Erişimi Ver**
   - Ayarlar → Uygulamalar → Özel Uygulama Erişimi
   - Bildirim Erişimi → Notification Alarm seç

3. **Test Et**
   - Başka bir uygulamadan belirtilen kelimeyle mesaj gönder
   - Telefon titreşmeye başlarsa başarılı!

### Örnek Kullanım

**Anahtar Kelimeler**: `sos, acil, tehlike`  
**Durma Kelimesi**: `panik iptal`

Eğer bildirimlerde "acil durum" yazıyorsa → Alarm başlar ⏰  
Eğer bildirimlerde "panik iptal" yazıyorsa → Alarm durur ✓

## Teknik Detaylar

- **Min SDK**: API 24 (Android 7.0)
- **Target SDK**: API 34 (Android 14)
- **Java Version**: 11
- **Architecture**: MVVM Pattern

## Dosya Yapısı

```
NotificationAlarmApp/
├── app/src/main/
│   ├── java/com/example/notificationalarm/
│   │   ├── MainActivity.java
│   │   ├── NotificationListenerService.java
│   │   ├── AlarmController.java
│   │   └── NotificationAlarmApp.java
│   ├── res/
│   │   ├── layout/activity_main.xml
│   │   └── values/{strings,colors,themes}.xml
│   └── AndroidManifest.xml
├── build.gradle
└── settings.gradle
```

## Sorun Giderme

**Problem**: Alarm çalışmıyor  
**Çözüm**: 
- Ayarlar → Bildirim Erişimi'nde app'ı kontrol et
- Cihazı yeniden başlat
- Bildirimlerin uygulamadan geldiğini kontrol et

**Problem**: Titreş çalışmıyor  
**Çözüm**:
- Ayarlar → Bildirim → Titreş seçeneğini aç
- Cihaz sesiz modda olmadığını kontrol et

## Geliştirme

Eklenebilir özellikler:
- 🔔 Ses alarmı ekleme
- 📱 Ekran açılması
- ⏱️ Zamanlanmış alarm
- 📊 Log tutma
- 🌙 Gece modu ayarı

## License

MIT License - Özgürce kullanabilirsiniz

---

**Geliştirici**: alpella35  
**Son Güncelleme**: 2026
