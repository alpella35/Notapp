package com.example.notificationalarm;

/**
 * Anahtar kelime eşleştirme motoru
 * Android bağımlılığı olmayan basit işlerle test edilebilir
 */
public class KeywordMatcher {
    
    private String[] keywords;
    private String stopKeyword;

    public KeywordMatcher(String keywordsInput, String stopKeywordInput) {
        this.keywords = keywordsInput.split(",");
        this.stopKeyword = stopKeywordInput.trim();
    }

    /**
     * Metinde durma kelimesini kontrol et
     */
    public boolean isStopKeywordFound(String text) {
        if (stopKeyword == null || stopKeyword.isEmpty()) {
            return false;
        }
        return text.toLowerCase().contains(stopKeyword.toLowerCase());
    }

    /**
     * Metinde anahtar kelimeleri kontrol et
     */
    public boolean isKeywordFound(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }

        for (String keyword : keywords) {
            keyword = keyword.trim();
            if (!keyword.isEmpty() && text.toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Hangi anahtar kelimenin bulunduğunu döndür
     */
    public String getMatchedKeyword(String text) {
        for (String keyword : keywords) {
            keyword = keyword.trim();
            if (!keyword.isEmpty() && text.toLowerCase().contains(keyword.toLowerCase())) {
                return keyword;
            }
        }
        return null;
    }
}
