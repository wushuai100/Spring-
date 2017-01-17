package com.goldendog.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
	public static Properties props;
	static{
		props = new Properties();
		try {
			props.load(PropertiesHelper.class.getResourceAsStream("/settings.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static String getProperty(String propertyName){
		return props.getProperty(propertyName);
	}
	
	
	public static String getPaladinRootUri(){
		return props.getProperty("paladinRootUri");
	}
	
	public static String getDefaultStationId(){
		return props.getProperty("defaultStationId");
	}
	
	public static String getDefaultCourierId(){
		return props.getProperty("defaultCourierId");
	}
	
	public static String getPaladinDbUrl(){
		return props.getProperty("paladinDbUrl");
	}
}
