package com.RegularExpresions;

/**
 * Created by esavitski on 01.02.2017.
 */
public class TestClass {

    public static void main(String[] args){
        System.out.println(getPartOfString("A\tB\tC\tD\tE\tF\tG\tH\tI"));
    }

    public static String getPartOfString(String string) {
        return string.substring(string.indexOf("\t")+1, string.lastIndexOf("\t"));
    }
}
