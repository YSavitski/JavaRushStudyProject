package com.savitsky.blinovBook.chapter_07.variant_C;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by esavitski on 18.04.2017.
 */
public class Burrows_Wheeler {
    public static void main(String[] args){
        String testString = null;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            testString = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(testString!=null){
            System.out.println(transformation(testString));
        }
    }

    @NotNull
    private static String transformation(String inputString){
        List<String> cyclicShifts = new ArrayList<>();
        StringBuilder strBuilder = new StringBuilder(inputString);
        StringBuilder resultBuilder = new StringBuilder();
        for (int i=0; i<inputString.length(); i++){
            cyclicShifts.add(strBuilder.toString());
            strBuilder.append(strBuilder.toString().charAt(0));
            strBuilder.deleteCharAt(0);
        }
        Collections.sort(cyclicShifts, String.CASE_INSENSITIVE_ORDER);
        cyclicShifts.stream().forEach(s -> {resultBuilder.append(s.charAt(s.length()-1));} );
        return resultBuilder.toString();
    }
}
