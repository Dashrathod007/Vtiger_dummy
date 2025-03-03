package com.comcast.crm.generic.FileUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility 
{
	public String getDataFromPropertiesFile(String key) throws Exception
	{
		FileInputStream fis= new FileInputStream(FilePathConstant.PropertiesFile);
		Properties pobj=new Properties();
		pobj.load(fis);
		String data = pobj.getProperty(key);
		
		return data;
		
	}
}
