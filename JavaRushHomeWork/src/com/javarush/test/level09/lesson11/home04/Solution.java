package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat formatterFrom = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat formatterTo = new SimpleDateFormat("MMM dd, yyyy");
        Date date = formatterFrom.parse(reader.readLine());
        System.out.println(formatterTo.format(date).toUpperCase());
    }
}
