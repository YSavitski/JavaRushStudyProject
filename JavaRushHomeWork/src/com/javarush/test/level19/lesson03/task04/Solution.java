package com.javarush.test.level19.lesson03.task04;

import java.io.*;
import java.util.*;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner originalScanner;
        public PersonScannerAdapter(Scanner scanner){
            this.originalScanner = scanner;
        }


        @Override
        public Person read() throws IOException
        {
            String[] personInfo = originalScanner.nextLine().split(" ");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(personInfo[5]), Integer.parseInt(personInfo[4])-1, Integer.parseInt(personInfo[3]));
            return new Person(personInfo[0], personInfo[1], personInfo[2], calendar.getTime());
        }


        @Override
        public void close() throws IOException
        {
            originalScanner.close();
        }
    }
}
