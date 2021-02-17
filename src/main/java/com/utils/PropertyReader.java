package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    static Properties properties;

    public PropertyReader() {
        loadAllProperties( );
    }

    public void loadAllProperties() {
        properties = new Properties( );
        try {

            String propertyFilePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";
            properties.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Not able to read the File prod_config.properties ");
        }
    }

    public static String readItem(String propertyName) {
    	
    	System.out.println(propertyName);
        return properties.getProperty(propertyName);
    }


}
