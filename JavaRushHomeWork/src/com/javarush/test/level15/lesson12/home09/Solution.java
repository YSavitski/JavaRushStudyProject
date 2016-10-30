package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputURL = null;


        try
        {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), "?");
            while (tokenizer.hasMoreTokens())
            {
                inputURL = tokenizer.nextToken();
            }
        }
        catch (IOException ex)
        {
            ex.getStackTrace();
        }

        Map<String, String> map = new HashMap<String, String>();
        StringTokenizer newTokenizer = new StringTokenizer(inputURL, "&");

        String temp = null;
        do
        {
            temp = newTokenizer.nextToken();
            String subName = null;
            String subValue = null;
            int index = temp.indexOf("=");
            if(temp.contains("="))
            {
                subName = temp.substring(0, index);
                subValue = temp.substring(index+1);
                map.put(subName, subValue);
            }
            else
            {
                map.put(temp, null);
            }
        }while (newTokenizer.hasMoreTokens());


        String objValue = null;
        for (Map.Entry<String, String> mapItem:
             map.entrySet())
        {
            if(mapItem.getKey().equals("obj"))
            {
                objValue = mapItem.getValue();
            }

            System.out.print(mapItem.getKey() + " ");
        }
        System.out.println();

        if(objValue!=null)
        {
            try
            {
                if(objValue.contains("."))
                {
                    alert(Double.parseDouble(objValue));
                }
            } catch (Exception ex)
            {
                alert(objValue.toString());
            }
        }
*/


        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] url = null;

        try
        {
            url = r.readLine().split("[?&]");         //создаем массив строк с разделителями & и ?
        }catch (IOException ex)
        {
            ex.getStackTrace();
        }

        String str=""; //строка, которая будет содержать все параметры

        for (int i = 1; i < url.length; i++) //цикл, наполняющий str параметрами
        {
            if(url[i].contains("="))
                str+=url[i].substring(0, url[i].indexOf("="))+" ";
            else
                str+=url[i]+" ";
        }
        str=str.trim(); //удаляем лишние пробелы по краям строки
        System.out.print(str.replaceAll("[\\s]{2,}", " ")); //выводим str на экран без лишних пробелов
        System.out.println();
        for (int i = 0; i < url.length; i++) //передаем значение(-я) параметра obj в метод alert
        {
            try{ if (url[i].length()>0 && url[i].substring(0, url[i].indexOf("=")).equals("obj"))
            {
                try
                {
                    alert(Double.parseDouble((url[i].substring(url[i].indexOf("=") + 1, url[i].length()))));
                }
                catch (Exception e)
                {
                    alert((url[i].substring(url[i].indexOf("=") + 1, url[i].length())));
                }
            }

            } catch (Exception e){}
        }



    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
