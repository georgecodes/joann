package com.elevenware.joann;

/**
 * Format
 * Represents different input formats for setting Joda time
 *
 * @since 1.0
 * @author George McIntosh
 */
public enum Format {

    DEFAULT(""),
    USE_MILLIS(""),
    ISO(""),
    YYYYMMDD("yyyy-MM-dd"),
    YYYYMMDD_HHMMSS("yyyy-MM-dd HH:mm:ss");

    private Format(String pattern) {
        this.pattern = pattern;
    }
    private String pattern;

    public String pattern() {
        return this.pattern;
    }

}
