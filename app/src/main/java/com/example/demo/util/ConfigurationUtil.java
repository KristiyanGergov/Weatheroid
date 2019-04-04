package com.example.demo.util;

import com.example.demo.MainApplication;
import com.example.demo.MainFragment;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class ConfigurationUtil {

    private static MainApplication mainApplication;


    private static String getProperty(String key) {

        try (InputStream is = Objects.requireNonNull(MainFragment.newInstance()
                .getContext())
                .getAssets()
                .open("configuration.properties")) {

            Properties props = new Properties();
            props.load(is);

            return props.getProperty(key, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getWeatherKey() {
        return getProperty("weatherKey");
    }

    public static String getWeather() {
        return getProperty("weather");
    }

}
