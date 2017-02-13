package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = 0;
        int counter = 0;
        int sum = 0;
        while ((inputNumber = Integer.parseInt(consoleReader.readLine())) != -1){
            sum += inputNumber;
            counter++;
        }
        System.out.println((double)sum / (double)counter);
    }
}

