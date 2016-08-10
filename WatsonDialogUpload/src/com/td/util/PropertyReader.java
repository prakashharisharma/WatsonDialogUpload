package com.td.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	private static volatile PropertyReader self= null;

	private Properties  prop = null;
	
	private InputStream input = null;

	private PropertyReader() {
		try {
			prop = new Properties();
			input = new FileInputStream("resources/config.properties");
			prop.load(input);
		} catch(Exception e){
			System.out.println("*** Properties file not found on location.");
		}
	}

	public static PropertyReader getInstance() {
		if(self == null) {
			synchronized (PropertyReader.class) {
				if(self == null) {
					self = new PropertyReader();
				}
			}
		}
		return self;
	}


	public String getProperty(String key) {
		return prop.getProperty(key);
	}
}
