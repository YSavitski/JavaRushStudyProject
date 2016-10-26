package com.javarush.test.level14.lesson08.bonus01;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        String siteURL = null;
        URL url;
        try
        {
            url = new URL(siteURL);
        }catch (MalformedURLException e)
        {
            exceptions.add(e);
        }

        String str;
        try
        {
            throw new RuntimeException();
        }catch (Exception e){ exceptions.add(e);}

        try
        {
            throw new NullPointerException();
        }catch (Exception e){ exceptions.add(e);}

        try
        {
            throw new IllegalMonitorStateException();
        }catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new NumberFormatException();
        } catch (Exception e){ exceptions.add(e);}

        try
        {
            throw  new ClassCastException();
        } catch (Exception e){ exceptions.add(e);}

        try
        {
            throw new Exception();
        } catch (Exception e) { exceptions.add(e);}

        int a[] = {10,20};
        try
        {
            System.out.println(a[30]);
        }catch (Exception e){ exceptions.add(e);}

        try
        {
            throw new InputMismatchException();
        }catch (Exception e){ exceptions.add(e);}




        //Add your code here

    }
}
