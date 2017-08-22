//package com.crunchify.tutorials;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.lang.*;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;

/* 
 * @author Crunchify.com
 */
 
public class location {
 
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws 
            IOException, ParseException {
		 		
		JSONParser parser = new JSONParser();
		File f = new File("/home/ubuntu/studyGroup-GSOC/data/whereweare.geojson");
		if (f.exists()) {
			JSONArray loc_json = new JSONArray();
			Map<String, Integer> lookup = new HashMap<String, Integer>();
			JSONObject a = (JSONObject) parser.parse(new FileReader("/home/ubuntu/studyGroup-GSOC/data/whereweare.geojson"));
			//String str= (String) a.get("type");
			JSONArray features = (JSONArray) a.get("features");
			for(int i=0; i<features.size(); i++){
				JSONObject features_obj = (JSONObject) features.get(i);
			//	String features_str = (String) features_obj.get("type");
				JSONObject features_prop = (JSONObject) features_obj.get("properties");
				String str_loc = (String) features_prop.get("location");
		//		System.out.println(str_loc);

				List<String> list_loc = Arrays.asList(str_loc.split(","));
				int n = list_loc.size();
				String loc = list_loc.get(n-1);
				if(lookup.get(loc) == null){
					lookup.put(loc, 1);
				}		
				else{
					int value = lookup.get(loc);
					value++;
					lookup.put(loc, value);
				}		
				System.out.println(loc);
			}
			for(Map.Entry<String, Integer> entry : lookup.entrySet()){
				JSONObject loc_obj = new JSONObject();
				loc_obj.put("Country", entry.getKey());
				loc_obj.put("Count", entry.getValue());
				loc_json.add(loc_obj);
			}
			try(FileWriter file = new FileWriter("/home/ubuntu/Documents/countries.json")){
				file.write(loc_json.toJSONString());			
	
			}catch (Exception e){
				e.printStackTrace();
			}	
		}			 
	}	
}
