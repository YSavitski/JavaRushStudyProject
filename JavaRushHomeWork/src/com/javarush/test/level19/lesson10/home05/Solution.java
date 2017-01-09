package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if(args.length<2){
            return;
        }

        BufferedReader file1Reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        FileWriter file2Writer = new FileWriter(args[1]);

        String temp = null;
        boolean containsNumbers;
        while((temp = file1Reader.readLine()) != null){
            String[] tempArr = temp.split(" ");
            for (String word:
                 tempArr)
            {
                containsNumbers = false;
                for (String letter:
                     word.split(""))
                {
                    if(letter.matches("[0-9]")){
                        containsNumbers = true;
                    }
                }
                if(containsNumbers == true){
                    file2Writer.write(word);
                }
            }
        }
        file1Reader.close();
        file2Writer.close();
    }
}
