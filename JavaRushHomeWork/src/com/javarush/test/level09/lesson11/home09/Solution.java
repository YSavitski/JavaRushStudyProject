package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        Map<String, Cat> newMap = new HashMap<String, Cat>();
        newMap.put("cat1", new Cat("cat1"));
        newMap.put("cat2", new Cat("cat2"));
        newMap.put("cat3", new Cat("cat3"));
        newMap.put("cat4", new Cat("cat4"));
        newMap.put("cat5", new Cat("cat5"));
        newMap.put("cat6", new Cat("cat6"));
        newMap.put("cat7", new Cat("cat7"));
        newMap.put("cat8", new Cat("cat8"));
        newMap.put("cat9", new Cat("cat9"));
        newMap.put("cat10", new Cat("cat10"));
        return newMap;
    }


    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        Set<Cat> newSet = new HashSet<Cat>();
        for (Map.Entry<String, Cat> item:
             map.entrySet())
        {
            newSet.add(item.getValue());
        }
        return newSet;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
