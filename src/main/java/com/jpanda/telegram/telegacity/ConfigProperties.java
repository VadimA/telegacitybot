package com.jpanda.telegram.telegacity;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Alexey Storozhev
 */
public class ConfigProperties {

    private static String CONFIG_FILE = "config.properties";

    static Properties property = new Properties();

    public static void init() {
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/main/resources/" + CONFIG_FILE);
            property.load(fis);
        } catch (IOException e) {
            System.err.println("Exception! Property file is not found.");
        }

    }

    public static String getProperty(String name) {
        return property.getProperty(name);
    }

    public static void setConfigFile(String configFile) {
        CONFIG_FILE = configFile;
    }
}