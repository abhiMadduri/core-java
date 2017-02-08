package com.java.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamFilterTest {
    public static void main(String[] args) {
        Map<Integer, String> bookMap = new HashMap<>();
        bookMap.put(1, "Java 8");
        bookMap.put(2, "Spring");
        bookMap.put(3, ".Net");
        bookMap.put(4, "Ruby on rails");

        String result = "";
        for (Map.Entry<Integer, String> entry : bookMap.entrySet()) {
            if (".Net".equals(entry.getValue())) {
                result = entry.getValue();
            }
        }
        System.out.println("Before Java 8 : " + result);

        //Map -> Stream -> Filter -> String
        result = bookMap.entrySet().stream()
                .filter(map -> ".Net".equals(map.getValue()))
                .map(map -> map.getValue())
                .collect(Collectors.joining());

        System.out.println("With Java 8 : " + result);
        
      //Map -> Stream -> Filter -> Map
        Map<Integer, String> collect = bookMap.entrySet().stream()
                .filter(map -> map.getKey() == 2)
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        System.out.println(collect); //output : {2=Spring}
    }
}
