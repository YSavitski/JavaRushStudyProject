package com.javarush.test.level08.lesson11.home09;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{


    public static void main(String[] args)
    {

    }

    public static boolean isDateOdd(String date)
    {
        Date currentTime = new Date(date);
        Date yearStartTime = new Date(currentTime.getYear(),0,1,0,0,0);
        long msDay = 24*60*60*1000;
        long msDistance = currentTime.getTime() - yearStartTime.getTime();
        long days = msDistance/msDay + 1;
        return days % 2 == 0 ? false : true;
        /*char[] indexes = date.toCharArray();
        int index1=0, index2=0;

        for (int i=0; i<indexes.length; i++)
        {
            if(indexes[i] == ' ')
            {
                index1 = i;
                break;
            }
        }
        for (int i=index1+1; i<indexes.length; i++)
        {
            if(indexes[i] == ' ')
            {
                index2 = i;
                break;
            }
        }
        int month = monthInt(date.substring(0, index1));
        int day = Integer.parseInt(date.substring(index1+1, index2));
        int year = Integer.parseInt(date.substring(index2+1));

        Date startDate = new Date();
        Date currentDate = new Date();
        startDate.setHours(0); startDate.setMinutes(0); startDate.setSeconds(0);
        startDate.setDate(1); startDate.setMonth(0); startDate.setYear(year);
        currentDate.setHours(0); currentDate.setMinutes(0); currentDate.setSeconds(0);
        currentDate.setDate(day); currentDate.setMonth(month); currentDate.setYear(year);

        if(((currentDate.getTime() - startDate.getTime())/(24 * 60 * 60 * 1000) + 1) % 2 == 0)
        {
            //System.out.println((currentDate.getTime() - startDate.getTime())/(24 * 60 * 60 * 1000) + 1);
            return false;

        }
        else
            {
                //System.out.println((currentDate.getTime() - startDate.getTime())/(24 * 60 * 60 * 1000) + 1);
                return true;
            }*/
    }

    /*private static HashMap<String, Integer> enumMonths()
    {
        HashMap<String, Integer> month = new HashMap<String, Integer>();
        month.put("JANUARY", 0); month.put("FEBRUARY", 1); month.put("MARCH", 2); month.put("APRIL", 3); month.put("MAY", 4);
        month.put("JUNE", 5); month.put("JULY", 6); month.put("AUGUST", 7); month.put("SEPTEMBER", 8);
        month.put("OCTOBER", 9); month.put("NOVEMBER", 10); month.put("DECEMBER", 11);

        return month;
    }
    public static int monthInt(String month)
    {
        int result = 0;
        for (Map.Entry<String, Integer> pair:
             enumMonths().entrySet())
        {
            if(pair.getKey().equals(month))
            {
                result = pair.getValue();
            }
        }
        return result;
    }*/
}
