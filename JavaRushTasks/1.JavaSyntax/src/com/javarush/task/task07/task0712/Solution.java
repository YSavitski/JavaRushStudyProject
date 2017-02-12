package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            list.add(consoleReader.readLine());
        }
        consoleReader.close();

        int indexMax = 0;
        int indexMin = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).length() > list.get(indexMax).length()){
                indexMax = i;
            }
            if(list.get(i).length() < list.get(indexMin).length()){
                indexMin = i;
            }
        }

        if(indexMax < indexMin){
            System.out.println(list.get(indexMax));
        }
        else {
            System.out.println(list.get(indexMin));
        }
    }
}
