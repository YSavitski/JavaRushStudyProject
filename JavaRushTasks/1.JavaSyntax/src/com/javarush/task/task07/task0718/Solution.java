package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String>  list = new ArrayList<>();
        for (int i=0; i<10; i++){
            list.add(consoleReader.readLine());
        }
        consoleReader.close();
        boolean sorted = true;

        int indexGreter = 0;
        for (int i =1; i< list.size(); i++){
            if(list.get(i).length() <= list.get(indexGreter).length() ){
                System.out.println(i);
                break;
            }
            else {
                indexGreter = i;
                continue;
            }
        }

    }
}

