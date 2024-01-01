package com.cucumber.pom.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

//import org.apache.commons.lang.StringUtils;

public class PropertiesOperations {
	static Properties prop = new Properties();

	public static String getPropertyValueByKey(String key) {
		String propFilePath = System.getProperty("user.dir") + "/src/test/resources/Project.properties";
		FileInputStream fis;

		try {
			fis = new FileInputStream(propFilePath);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String value = prop.get(key).toString();
		if (StringUtils.isEmpty(value)) {
			try {
				throw new Exception("Value is not sspecified for key " + key + " in properties file");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
        return value;
	}
}
