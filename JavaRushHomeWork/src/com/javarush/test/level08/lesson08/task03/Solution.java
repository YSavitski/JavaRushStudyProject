package com.javarush.test.level08.lesson08.task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap() throws IOException
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> phonebook = new HashMap<String, String>();
        phonebook.put("1", "111");
        phonebook.put("2", "111");
        phonebook.put("3", "111");
        phonebook.put("4", "222");
        phonebook.put("5", "222");
        phonebook.put("6", "333");
        phonebook.put("7", "333");
        phonebook.put("8", "333");
        phonebook.put("9", "333");
        phonebook.put("10", "333");

        return phonebook.isEmpty() ? null : phonebook;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int result = 0;

        for (Map.Entry<String, String> item:
             map.entrySet())
        {
            if(item.getValue().equals(name))
            {
                result++;
            }
        }
        return result;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        int result = 0;

        for (Map.Entry<String, String> item:
                map.entrySet())
        {
            if(item.getKey().equals(lastName))
            {
                result++;
            }
        }
        return result;

    }

    /*public static void main(String[] args) throws Exception
    {
        HashMap<String, String> myMap = createMap();
        for (Map.Entry<String, String> item:
        myMap.entrySet())
        {
            System.out.println("lastname is " + item.getKey() + ": firstname is " + item.getValue());
        }
    }*/
}
