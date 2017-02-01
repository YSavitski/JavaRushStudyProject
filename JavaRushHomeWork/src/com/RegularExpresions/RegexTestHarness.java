package com.RegularExpresions;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by esavitski on 01.02.2017.
 */
public class RegexTestHarness {
    public static void main(String[] args){
        Console console = System.console();
        if(console == null){
            System.err.println("No console!");
            System.exit(1);
        }

        while(true){
            Pattern pattern = Pattern.compile(console.readLine("%nEnter your regex: "));
            Matcher matcher = pattern.matcher(console.readLine("Enter input string to search: "));

            boolean foundStr = false;
            while (matcher.find()){
                console.format("I found the text" + " \"%s\" starting at index %d and ending at index %d.%n",
                        matcher.group(), matcher.start(), matcher.end());
                foundStr = true;
            }

            if(!foundStr){
                console.format("No match found.%n");
            }
        }
    }
}
