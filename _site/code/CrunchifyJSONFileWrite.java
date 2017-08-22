//package com.crunchify.tutorials;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/* 
 * @author Crunchify.com
 */
 
public class CrunchifyJSONFileWrite {
 
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws 
            IOException, ParseException {
		 		
		JSONArray overall = new JSONArray();
		JSONArray single_event = new JSONArray();
		
		JSONObject obj = new JSONObject();

		File folder = new File("/home/ubuntu/sg-events/data");
		File[] listOfFiles = folder.listFiles();
		
		for (int i=0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory: " + listOfFiles[i].getName());
			JSONObject name_count = new JSONObject();
                        JSONParser parser = new JSONParser();
			File f = new File("/home/ubuntu/sg-events/data/" + listOfFiles[i].getName() + "/data.json");
			if (f.exists()) {
	                	JSONArray a = (JSONArray) parser.parse(new FileReader(
        	        	"/home/ubuntu/sg-events/data/" + listOfFiles[i].getName() + "/data.json"));
				int count = 0;
        	        	for (Object o : a)
                		{
                        		JSONObject person = (JSONObject) o;
                        		count++;
                		}
                		System.out.println("The count is " + count);
				name_count.put("Event", count);	
				name_count.put("Name", listOfFiles[i].getName());
				single_event.add(name_count);
			}
			else {
				name_count.put("Event", 0);
                                name_count.put("Name", listOfFiles[i].getName());
                                single_event.add(name_count);
			}

			}
		}
		try (FileWriter file = new FileWriter("/home/ubuntu/Documents/single_event.json")) {
			file.write(single_event.toJSONString());
		} 
				 
	}
}
