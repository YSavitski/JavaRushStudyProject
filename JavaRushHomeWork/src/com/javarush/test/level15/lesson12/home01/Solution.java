package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();

        String input;
        while(true){
            input = reader.readLine();
            if(input.equals("exit")){
                break;
            }

            list.add(input);
        }

        for (String item:
             list)
        {
            if(item.contains("."))
            {
                try
                {
                    print(Double.parseDouble(item));
                }catch (NumberFormatException ex)
                {
                    print(item);
                }
            }
            else
                {
                    try
                    {
                        int number = Integer.parseInt(item);
                        if(number > 0 && number < 128)
                        {
                            print((short)number);
                        }
                        else if(number >= 128)
                        {
                            print(number);
                        }
                    }
                    catch (NumberFormatException ex)
                    {
                        print(item);
                    }
                }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
