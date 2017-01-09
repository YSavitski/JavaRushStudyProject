package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static ArrayList<String> listOfWords = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {

        if(args.length<2){
            return;
        }
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        String tempStr = null;
        while((tempStr = fileReader.readLine()) != null){
            for (String word:
                 tempStr.split(" "))
            {
                if(word.length() > 6){
                    listOfWords.add(word);
                }
            }
        } fileReader.close();

        StringBuilder resultString = new StringBuilder();
        for(int i=0; i<listOfWords.size(); i++){
            if(i == listOfWords.size()-1){
                resultString.append(listOfWords.get(i));
            }
            else{
                resultString.append(listOfWords.get(i)+",");
            }
        }

        PrintWriter fileWriter = new PrintWriter(new FileWriter(args[1]));
        fileWriter.println(resultString.toString());
        fileWriter.close();


    }
}
