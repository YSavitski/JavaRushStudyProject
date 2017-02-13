package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static int countPeoplesInEven = 0;
    public static int countPeoplesInOdd = 0;
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] streetArray = new int[15];
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i < streetArray.length; i++){
            streetArray[i] = Integer.parseInt(consoleReader.readLine());
        }
        consoleReader.close();

        for(int i =0; i<streetArray.length; i++){
            if(i==0 || i%2==0){
                countPeoplesInEven += streetArray[i];
            }
            else{
                countPeoplesInOdd += streetArray[i];
            }
        }

        if(countPeoplesInEven > countPeoplesInOdd){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
        else if(countPeoplesInOdd > countPeoplesInEven){
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
