package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFileName = null;
        while(!(inputFileName = reader.readLine()).equals("exit")){
            if(inputFileName != null){
                new ReadThread(inputFileName).start();
            }
        } reader.close();

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run(){
            try
            {
                GetElementWithMaxFrequncy(CountingFrequency(ReadFile(this.fileName)), this.fileName);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        private synchronized ArrayList<Integer> ReadFile(String fileName) throws IOException
        {
            ArrayList<Integer> listOfBytes = new ArrayList<>();
            FileInputStream inFileStream = new FileInputStream(fileName);
            while (inFileStream.available() > 0){
                listOfBytes.add(inFileStream.read());
            }
            inFileStream.close();
            return listOfBytes;
        }

        private synchronized Map<Integer, Integer> CountingFrequency(ArrayList<Integer> listWithBytes){
            Map<Integer, Integer> frequencyMap = new TreeMap<>();
            int count;
            for(int i=0; i<listWithBytes.size(); i++){
                count = 0;
                for (int j =0; j<listWithBytes.size(); j++){
                    if(listWithBytes.get(i)==listWithBytes.get(j)){
                        count++;
                    }
                }
                frequencyMap.put(listWithBytes.get(i), count);
            }
            return sortbyValue(frequencyMap);
        }


        private synchronized static Map<Integer, Integer> sortbyValue(Map<Integer, Integer> map){
            Map.Entry<Integer, Integer>[] array = map.entrySet().toArray(new Map.Entry[map.size()]);
            Arrays.sort(array, new Comparator<Map.Entry<Integer, Integer>>()
            {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
                {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            Map<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
            for(Map.Entry<Integer, Integer> entry : array){
                result. put(entry.getKey(), entry.getValue());
            }
            return result;
        }

        private synchronized void GetElementWithMaxFrequncy(Map<Integer, Integer> map, String fileName){
            Map.Entry<Integer, Integer> entryMap = (Map.Entry<Integer, Integer>) map.entrySet().iterator().next();
            resultMap.put(fileName, entryMap.getKey());
        }

    }
}
