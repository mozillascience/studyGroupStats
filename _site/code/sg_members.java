//package com.crunchify.tutorials;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.*;
import java.io.FileWriter;
import java.lang.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/* 
 * @author Crunchify.com
 */
 
public class sg_members {
 
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws 
            IOException, ParseException {
		 		
		JSONArray overall = new JSONArray();
		JSONArray single_event = new JSONArray();
		
		JSONObject obj = new JSONObject();

		File folder = new File("/home/ubuntu/Downloads/sg-events/data_mem/");
		File[] listOfFiles = folder.listFiles();
		
		for (int i=0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory: " + listOfFiles[i].getName());
			JSONObject name_count = new JSONObject();
                        JSONParser parser = new JSONParser();
			File f = new File("/home/ubuntu/Downloads/sg-events/data_mem/" + listOfFiles[i].getName() + "/data.txt");
			if (f.exists()) {
				int count = 0;
				FileReader fr = new FileReader(f);
	                        BufferedReader br = new BufferedReader(fr);
				String line;
				while((line = br.readLine()) != null){
					if(line.contains("name")){
						System.out.println("hello" + line);
						count++;
					}
				}
                		System.out.println("The count is " + count);
				name_count.put("Members", count);	
				name_count.put("Name", listOfFiles[i].getName());
				single_event.add(name_count);
			}

			}
		}
		try (FileWriter file = new FileWriter("/home/ubuntu/AnamikaD.github.io/data/sg_members.json")) {
			file.write(single_event.toJSONString());
		} 
				 
	}
}
