package com.comcast.crm.generic.FileUtility;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class jsonUtility
{
	public String getDataFromJsonFile(String key) throws Exception
	{
		FileReader fileR= new FileReader("./ConfigAppData/AppCommonData.json");
		JSONParser parser= new JSONParser();
		Object obj=parser.parse(fileR);
		
		JSONObject map=(JSONObject)obj;
		String data =(String)map.get(key);
		return data;
		
		
		
		
	}

}
