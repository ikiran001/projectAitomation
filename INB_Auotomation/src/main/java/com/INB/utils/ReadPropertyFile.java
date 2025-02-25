package com.INB.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.INB.constants.FrameworkConstants;

import enums.ConfigProperties;

public final class ReadPropertyFile {

	private ReadPropertyFile() {

	}

	private static Properties property=new Properties();
	private static final Map<String, String> CONFIGMAP=new HashMap<String, String>();

	static {
		try {
			FileInputStream file=new FileInputStream(FrameworkConstants.getConfigfilepath());
			property.load(file);

			for(Object key : property.keySet()) {
				CONFIGMAP.put(String.valueOf(key), String.valueOf(property.get(key)).trim());

			}

		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();

		}
	}

	public static String get(ConfigProperties key) throws Exception {
		if(Objects.isNull(key.name().toLowerCase()) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property name "+key+" is not available in configuration file ");
		}
		return CONFIGMAP.get(key.name().toLowerCase());//returns the value of the provided key
	}

	/*
	 * public static String getConfigValue(String key) throws Exception {
	 * 
	 * 
	 * if(Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) { throw
	 * new
	 * Exception("Property name "+key+" is not available in configuration file "); }
	 * 
	 * return property.getProperty(key); }
	 */

}
