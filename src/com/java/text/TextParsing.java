package com.java.text;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TextParsing {
    public static void main (String args[]) {
        String filePath = "C:\\Tools\\Notes.txt";
        StringBuilder songBuilder = new StringBuilder();
        
        String path = "C:\\Tools\\code\\ionic\\praise-app-ionic\\src\\assets\\songs\\songs_english.json";
        JSONParser parser = new JSONParser();
        long id = 0;

        try {     
            JSONArray array = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : array) {
                JSONObject obj = (JSONObject) o;
                id = (long) obj.get("id");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        try {
            for(String str : Files.readAllLines(Paths.get(filePath))) {
                songBuilder.append(str).append("\n");
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        Map map = new LinkedHashMap<>();
        
        if (!songBuilder.toString().isEmpty()) {
            map.put("id", ++id);
            map.put("title", "Here I am to worship");
            map.put("lyrics_en", songBuilder.toString());
            map.put("video_links", "");
          
        }
        
        try (FileWriter file = new FileWriter(path, true)) {
            if (map != null) {
                file.write(JSONObject.toJSONString(map));
                file.flush();
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(obj.toJSONString());

    }
}
