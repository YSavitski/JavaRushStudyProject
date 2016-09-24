package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        int counter;
        Iterator<Map.Entry<String, String>> itOuter = map.entrySet().iterator();
        while (itOuter.hasNext())
        {
            Map.Entry<String, String> compareItem = itOuter.next();
            counter=0;
            Iterator<Map.Entry<String, String>> itInner = map.entrySet().iterator();
            while (itInner.hasNext())
            {
                Map.Entry<String, String> item = itInner.next();
                if(compareItem.getValue().equals(item.getValue()))
                {
                    counter++;
                    if(counter>1)
                    {
                        itOuter.remove();
                        break;
                    }
                }
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }


    /*public static void main(String[] args) throws Exception
    {
        HashMap<String, String> map = createMap();
        for (Map.Entry<String, String> item:
             map.entrySet())
        {
            System.out.print(item.getValue() + " ");
        }System.out.println();

        removeTheFirstNameDuplicates(map);
        for (Map.Entry<String, String> item:
                map.entrySet())
        {
            System.out.print(item.getValue() + " ");
        }System.out.println();
    }*/
}
