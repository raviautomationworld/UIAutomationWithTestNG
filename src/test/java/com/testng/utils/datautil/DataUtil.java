package com.testng.utils.datautil;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.testng.utils.logs.Log;

public class DataUtil {

	public static Properties prop;
	public static String currentProjectDirectory = System.getProperty("user.dir");
	public static Properties testDataProp(String fileName) {
		
		StringBuilder inputFile = new StringBuilder(fileName);
		
		prop = new Properties();
		try {
			Log.info("Get the "+inputFile+".properties file");
			File file = new File(currentProjectDirectory+"\\src\\test\\resources\\data\\"+inputFile+".properties");
			FileInputStream fileInput= new FileInputStream(file);
			Log.info("Load the "+inputFile+".properties file");
			prop.load(fileInput);		

		} catch (Exception e) {
			Log.error("Exception occured at method :::: testDataProp()");
			Log.error(e);
		}
		
		return prop;
	}
}
