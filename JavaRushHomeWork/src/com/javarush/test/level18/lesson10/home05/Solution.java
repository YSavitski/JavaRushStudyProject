package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathFile1= reader.readLine(), pathFile2= reader.readLine();
        reader.close();
        ArrayList<Float> listOfNumbers = new ArrayList<Float>();
        try{
            Scanner sc = new Scanner(new File(pathFile1));
            sc.useLocale(Locale.US);
            while(sc.hasNext()){
                listOfNumbers.add(sc.nextFloat());
            }
            sc.close();
        }   catch(FileNotFoundException e){
            e.printStackTrace();
        }

        try{
            PrintWriter pw = new PrintWriter(new File(pathFile2));
            for (Float num:
                 listOfNumbers)
            {
                pw.print(Math.round(num)+ " ");
            }
            pw.close();
        }   catch(Exception e){
                e.printStackTrace();
            }
    }
}