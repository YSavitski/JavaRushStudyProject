package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз - ягода, банан - трава, вишня - ягода, груша - фрукт, дыня - овощ, ежевика - куст, жень-шень - корень, земляника - ягода, ирис - цветок, картофель - клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель - клубень
*/

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("арбуз", "ягода"); myMap.put("банан", "трава"); myMap.put("вишня", "ягода"); myMap.put("груша", "фрукт");
        myMap.put("дыня", "овощ"); myMap.put("ежевика", "куст"); myMap.put("жень-шень", "корень"); myMap.put("земляника", "ягода");
        myMap.put("ирис", "цветок"); myMap.put("картофель", "клубень");

        for (Map.Entry<String, String> item:
             myMap.entrySet())
        {
            if(item.getValue() == "ягода")
            {
                System.out.println(item.getKey() + " - " + item.getValue());
            }
        }

    }
}
