package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
         /*
 Ожидаемый результат
 home - (5, 3) - (2, 0)
 same - (1, 1) - (4, 1)
          */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> result = new ArrayList<>();
        //each word:
        for (String word : words) {
            Word temp = new Word(word);
            byte[] splitWord = word.getBytes();
            int m = 0;
            int n = 0;


            //Поиск первой буквы
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (crossword[i][j] == (int) splitWord[0]) {
                        temp.setStartPoint(j, i);
                        m = i;
                        n = j;
                        break;
                    }
                }
            }


            //Поиск направления и следующие буквы
            int vector_i = 0;
            int vector_j = 0;
            for (int w = 1; w < word.length(); w++) {
                nextLetter:
                for (int i = -1; i <= 1; i++) {
                    if ((m + i < 0) || (m + i > crossword.length)) continue;
                    for (int j = -1; j <= 1; j++) {
                        if ((n + j < 0) || (n + j > crossword[m + i].length)) continue;
                        if (crossword[m + i][n + j] == (int) splitWord[w]) {
                            if ((vector_i == i && vector_j == j) || (vector_i == 0 && vector_j == 0)) {
                                temp.setEndPoint(n + j, m + i);
                                m = m + i;
                                n = n + j;
                                vector_i = i;
                                vector_j = j;
                                break nextLetter;
                            } else continue;
                        }
                    }
                }
            }
            result.add(temp);
            System.out.println(temp);
        }
        return result;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
