package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties props = new Properties();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        InputStream fileProperties = new FileInputStream(consoleReader.readLine());
        consoleReader.close();
        load(fileProperties);

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        //PrintWriter writer = new PrintWriter(outputStream);
        if(props.size() > 0){
            props.putAll(properties);
        }
        props.store(outputStream, "");
        //writer.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        //BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream));
        props.load(inputStream);
        Set<String> list = props.stringPropertyNames();
        for (String current:
             list) {
            System.out.println(current + " " + props.getProperty(current));
            properties.put(current, props.getProperty(current));
        }
        //buffReader.close();
    }

    public static void main (String[] args) throws Exception
    {
        new Solution().fillInPropertiesMap();
        System.out.println(properties);
        new Solution().save(new FileOutputStream("d:/2.properties"));
    }
}
