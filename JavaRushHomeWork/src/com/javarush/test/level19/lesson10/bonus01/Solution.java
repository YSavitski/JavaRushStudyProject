package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args){
        String fileName1 = null;
        String fileName2 = null;

        try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))){
            fileName1 = consoleReader.readLine();
            fileName2 = consoleReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> list1 = null;
        List<String> list2 = null;
        try {
             list1 = fileReading_listFilling(fileName1);
             list2 = fileReading_listFilling(fileName2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!list1.isEmpty() | !list2.isEmpty()) {
            if (list2.isEmpty()) {
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                list1.remove(0);
            }else if (list1.isEmpty()) {
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(0);
            }else if (list1.get(0).equals(list2.get(0))) {
                lines.add(new LineItem(Type.SAME, list1.get(0)));
                list1.remove(0);
                list2.remove(0);
            } else if (list1.get(0).equals(list2.get(1))) {
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(0);
            } else {
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                list1.remove(0);
            }
        }

        for (LineItem item:
             lines) {
            System.out.println(item.type.toString() + " " + item.line);
        }

    }

    public static List<String> fileReading_listFilling(String fileName) throws IOException {
        List<String> listWithLines = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String tempStr = null;
        while ((tempStr = fileReader.readLine()) != null){
            listWithLines.add(tempStr);
        }
        fileReader.close();
        return listWithLines;
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
