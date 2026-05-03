package com.example.notificationalarm;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KeywordMatcherTest {

    private KeywordMatcher matcher;

    @Before
    public void setUp() {
        matcher = new KeywordMatcher("acil, sos, tehlike", "tamam");
    }

    @Test
    public void testKeywordMatching() {
        assertTrue("'acil' kelimesi bulunmalı", 
            matcher.isKeywordFound("Bu bir acil durumdur"));
        
        assertTrue("'sos' kelimesi bulunmalı", 
            matcher.isKeywordFound("Sos yardım gerekli"));
        
        assertTrue("'tehlike' kelimesi bulunmalı", 
            matcher.isKeywordFound("Tehlike yaklaşıyor"));
    }

    @Test
    public void testKeywordNotMatching() {
        assertFalse("Kelime bulunmamalı", 
            matcher.isKeywordFound("Merhaba nasılsın?"));
    }

    @Test
    public void testCaseInsensitiveMatching() {
        assertTrue("Büyük/küçük harf duyarsız olmalı", 
            matcher.isKeywordFound("ACIL DURUM"));
        
        assertTrue("Büyük/küçük harf duyarsız olmalı", 
            matcher.isKeywordFound("SoS"));
    }

    @Test
    public void testStopKeywordMatching() {
        assertTrue("Durma kelimesi bulunmalı", 
            matcher.isStopKeywordFound("Tamam, durdu"));
        
        assertFalse("Durma kelimesi bulunmamalı", 
            matcher.isStopKeywordFound("Başladı"));
    }

    @Test
    public void testGetMatchedKeyword() {
        assertEquals("'acil' kelimesi eşleşmeli", "acil", 
            matcher.getMatchedKeyword("Bu bir acil durumdur"));
        
        assertNull("Eşleşen kelime olmayabilir", 
            matcher.getMatchedKeyword("Merhaba"));
    }

    @Test
    public void testEmptyText() {
        assertFalse("Boş metin hiçbir kelimeyle eşleşmemeli", 
            matcher.isKeywordFound(""));
    }

    @Test
    public void testMultipleKeywords() {
        KeywordMatcher multiMatcher = new KeywordMatcher("test, örnek, demo", "bitti");
        
        assertTrue("İlk kelime eşleşmeli", 
            multiMatcher.isKeywordFound("Bu bir test"));
        assertTrue("İkinci kelime eşleşmeli", 
            multiMatcher.isKeywordFound("Örnek ver"));
        assertTrue("Üçüncü kelime eşleşmeli", 
            multiMatcher.isKeywordFound("Demo zamanı"));
    }

    @Test
    public void testPartialKeywordMatching() {
        KeywordMatcher partialMatcher = new KeywordMatcher("alarm, test", "stop");
        
        // Kısmi eşleşme de bulunmalı
        assertTrue("Kısmi eşleşme: 'alarm' bulunmalı", 
            partialMatcher.isKeywordFound("alarmı kapat"));
        assertTrue("Kısmi eşleşme: 'test' bulunmalı", 
            partialMatcher.isKeywordFound("testi çalıştır"));
    }
}

