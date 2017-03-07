package com.java.text;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TeluguSongParsing {
    public static void main (String args[]) {
        String engFilePath = "C:\\Tools\\englishSong.txt";
        String telFilePath = "C:\\Tools\\teluguSong.txt";
        StringBuilder engSongBuilder = new StringBuilder();
        StringBuilder telSongBuilder = new StringBuilder();
        
        String path = "C:\\Tools\\code\\ionic\\praise-app-ionic\\src\\assets\\songs\\songs_telugu.json";
        JSONParser parser = new JSONParser();
        long id = 0;

        try {     
            JSONArray array = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : array) {
                JSONObject obj = (JSONObject) o;
                if (obj.get("id") != null) {
                    id = (long) obj.get("id");
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        try {
            for(String str : Files.readAllLines(Paths.get(engFilePath))) {
                engSongBuilder.append(str).append("\n");
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            for(String str : Files.readAllLines(Paths.get(telFilePath), StandardCharsets.UTF_8)) {
                telSongBuilder.append(str).append("\n");
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        Map map = new LinkedHashMap<>();
        
        if (!engSongBuilder.toString().isEmpty()) {
            map.put("id", ++id);
            map.put("title", "Anni Naamamula Kanna");
            map.put("lyrics_en", engSongBuilder.toString());
            if (!telSongBuilder.toString().isEmpty()) {
                map.put("lyrics_tel", telSongBuilder.toString());
            }
            map.put("video_links", "");
        }
        
        try (FileWriter file = new FileWriter(path, true)) {
            if (map != null) {
                file.write("," + JSONObject.toJSONString(map));
                file.flush();
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(obj.toJSONString());

    }
}
