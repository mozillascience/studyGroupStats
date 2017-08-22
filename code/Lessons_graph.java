//package com.crunchify.tutorials;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.*;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.lang.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/* 
 * @author Crunchify.com
 */
 
public class Lessons_graph {
 
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws 
            IOException, ParseException {
		try {
 		Process p = Runtime.getRuntime().exec(new String[]{"bash", "-c", "curl https://api.github.com/repos/mozillascience/studyGroupLessons/issues | grep 'labels/' > count"});
            	} catch(Exception e) {
			System.out.println("helo");
                	System.out.println(e.toString());
                	e.printStackTrace();
           	 }
		try {
			File f = new File("/home/ubuntu/Documents/count");
			//Scanner sc = new Scanner(new BufferedReader(new FileReader(f)));
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			Map<String, Integer> lookup = new HashMap<String, Integer>();	
			JSONArray levels = new JSONArray();
			JSONArray types = new JSONArray();
			String line;
			while((line = br.readLine()) != null){
				String[] details = line.split("/");
				String label = details[7];
				label = label.replaceAll("\"","");
				label = label.replaceAll(",","");
				label = label.replaceAll("%20"," ");
				System.out.println(label);
				if(lookup.get(label) == null ){
					lookup.put(label, 1);
				}
				else{
					int value = lookup.get(label);
					value++;
					lookup.put(label, value);
				}
			}


		for(Map.Entry<String, Integer> entry : lookup.entrySet()){
			JSONObject obj_level = new JSONObject();
			JSONObject obj_type = new JSONObject();
			System.out.println(entry.getKey()+" :: "+entry.getValue());
			String key = entry.getKey();
			if(key.equals("beginner") || key.equals("intermediate") || key.equals("advanced")){
				obj_level.put("Level", entry.getKey());
				obj_level.put("Count", entry.getValue());
				levels.add(obj_level);
			}
			else{
				obj_type.put("Type", entry.getKey());
				obj_type.put("Count", entry.getValue());
				types.add(obj_type);
			}
		}
		try(FileWriter file_level = new FileWriter("/home/ubuntu/AnamikaD.github.io/data/levels.json")){
			file_level.write(levels.toJSONString());
			
		}catch (Exception e){
			e.printStackTrace();
		}
		try(FileWriter file_type = new FileWriter("/home/ubuntu/AnamikaD.github.io/data/types.json")){
                        file_type.write(types.toJSONString());
                        
                }catch (Exception e){
                        e.printStackTrace();
                }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	 			
	}
}
