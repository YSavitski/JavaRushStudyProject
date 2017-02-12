package com.javarush.task.task08.task0818;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        BufferedReader consoleReader =new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<10; i++){
            map.put(String.valueOf(i+1), 495+i);
        }
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        ArrayList<String> keysForRemoving = new ArrayList<>();
        for (Map.Entry<String, Integer> entry :
                map.entrySet()){
            if(entry.getValue() < 500){
                keysForRemoving.add(entry.getKey());
            }
        }

        for (String key:
                keysForRemoving){
            map.remove(key);
        }
    }

    public static void main(String[] args) {

    }
}