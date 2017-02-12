package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int tempNumber = 0;
        int consoleNumber = 0;
        consoleNumber = Integer.parseInt(consoleReader.readLine());
        consoleReader.close();
        while(consoleNumber > 0){
            tempNumber = consoleNumber%10;
            if(tempNumber%2 == 0){
                even++;
            }
            else{
                odd++;
            }
            consoleNumber /= 10;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
