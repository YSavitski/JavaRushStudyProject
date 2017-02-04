package com.javarush.test.level22.lesson13.task02;
import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing
    static Charset windows1251 = Charset.forName("Windows-1251");
    static Charset utf8 = Charset.forName("UTF-8");

    public static void main(String[] args) throws IOException {
        String fileName1 = null, fileName2 = null;
        BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
        fileName1 = consolereader.readLine();
        fileName2 = consolereader.readLine();
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        FileInputStream inputStream = new FileInputStream(file1);
    }
}
