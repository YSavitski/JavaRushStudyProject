package com.savitsky.blinovBook.chapter_07.localeSamples;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by esavitski on 18.04.2017.
 */
public class HamletInternational {
    public static void main(String[] args){
        System.out.println("1 — английский \n 2 — белорусский \n любой — русский ");
        char j = 0;
        try {
            j = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String country = "";
        String language = "";
        switch (j) {
            case '1':
                country = "US";
                language = "EN";
                break;
            case '2':
                country = "BY";
                language = "BE";
                break;
        }

        Locale current = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("property.text", current);
        System.out.println(String.format("str1:\t%s\nstr2:\t%s", rb.getString("str1"), rb.getString("str2")));
    }
}
