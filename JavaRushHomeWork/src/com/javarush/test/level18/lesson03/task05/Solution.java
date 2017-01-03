package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
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

        ArrayList<Integer> listofBytes = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry:
             sortbyValue(map).entrySet())
        {
            listofBytes.add(entry.getKey());
        }

        Collections.sort(listofBytes);
        for (Integer item:
             listofBytes)
        {
            System.out.print(item + " ");
        }
    }
}