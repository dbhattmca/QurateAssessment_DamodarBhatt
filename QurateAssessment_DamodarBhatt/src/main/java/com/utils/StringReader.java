package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StringReader {
	
	static Properties properties;

    public  StringReader() {
        loadAllProperties( );
    }

    public void loadAllProperties() {
        properties = new Properties( );
        try {

            String propertyFilePath = System.getProperty("user.dir") + "/src/main/resources/string.properties";
            properties.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Not able to read the File string.properties");
        }
    }

    public static String readItem(String propertyName) {
    	
    	
        return properties.getProperty(propertyName);
    }



}
