package com.elevenware.joann;

import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DateFormatLoader {

    DateTimeFormatter load() {
        InputStream input = getClass().getClassLoader().getResourceAsStream("joann.properties");
        Properties properties = new Properties();
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(properties.getProperty("default.pattern"));

        return null;
    }

}
