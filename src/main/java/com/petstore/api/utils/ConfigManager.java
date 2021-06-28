package com.petstore.api.utils;

import java.io.*;
import java.util.Properties;

public class ConfigManager {

    private static ConfigManager manager;
    private static Properties properties = new Properties();
    private static final String CONFIG_PATH = "src\\main\\resources\\config.properties";

    private ConfigManager() throws IOException {
        InputStream input = new FileInputStream(CONFIG_PATH);
        properties.load(input);
    }

    public static ConfigManager getInstance() {
        if (manager == null) {
            synchronized (ConfigManager.class) {
                try {
                    manager = new ConfigManager();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return manager;
    }

    public String getString(String key) {
        return properties.getProperty(key);
    }
}