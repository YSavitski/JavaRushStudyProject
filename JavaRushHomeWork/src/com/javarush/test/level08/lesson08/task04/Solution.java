package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("1", new Date(1994, 4, 25));
        map.put("2", new Date(1994, 8, 9));
        map.put("3", new Date(1994, 6, 26));
        map.put("4", new Date(1987, 11, 23));
        map.put("5", new Date(1994, 7, 12));
        map.put("6", new Date("APRIL 4 1988"));
        map.put("7", new Date(1994, 7, 26));
        map.put("8", new Date(1994, 3, 17));
        map.put("9", new Date(1969, 2, 1));
        //напишите тут ваш код
        return map.isEmpty() ? null : map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        /*for (Map.Entry<String, Date> item:
             map.entrySet())
        {
            //if(item.getValue().getMonth())
            //.out.println(item.getKey() + " " + item.getValue().getMonth());
            if(item.getValue().getMonth() == 5 || item.getValue().getMonth() == 6 || item.getValue().getMonth() == 7)
            {
                map.remove(item.getKey());
            }
        }*/

        Iterator<Map.Entry<String, Date>> it = map.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String, Date> item = it.next();
            if(item.getValue().getMonth() > 4 && item.getValue().getMonth() < 8)
            {
                it.remove();
            }
        }
    }

    /*public static void main(String[] args) throws Exception
    {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
        for (Map.Entry<String, Date> item:
             map.entrySet())
        {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }*/
}
