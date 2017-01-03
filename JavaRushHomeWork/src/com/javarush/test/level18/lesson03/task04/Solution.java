package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {

    public static Map<Integer, Integer> sortbyValue(Map<Integer, Integer> map){
        Map.Entry<Integer, Integer>[] array = map.entrySet().toArray(new Map.Entry[map.size()]);
        Arrays.sort(array, new Comparator<Map.Entry<Integer, Integer>>()
        {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
        for(Map.Entry<Integer, Integer> entry : array){
            result. put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        reader.close();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> defArray = new ArrayList<Integer>();

        while (inputStream.available() > 0){
            defArray.add(inputStream.read());
        }
        inputStream.close();

        int count;
        for(int i=0; i<defArray.size(); i++){
            count = 0;
            for (int j =0; j<defArray.size(); j++){
                if(defArray.get(i)==defArray.get(j)){
                    count++;
                }
            }
            map.put(defArray.get(i), count);
        }

        int mincount = 1;
        for (Map.Entry<Integer, Integer> entry:
                sortbyValue(map).entrySet())
        {
            if(mincount==entry.getValue()){
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
