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
    private static Map<String, String> props = new HashMap<String, String>();
    private static String CONFIG_FILE = "config.properties";

    public static void init() {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/" + CONFIG_FILE);
            property.load(fis);
            Enumeration<?> e = property.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = new String(property.getProperty(key).getBytes("ISO-8859-1"), "UTF-8");
                props.put(key, value);
            }

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

    }

    public static String getProperty(String name) {
        return props.get(name);
    }

    public static void setConfigFile(String configFile) {
        CONFIG_FILE = configFile;
    }
}