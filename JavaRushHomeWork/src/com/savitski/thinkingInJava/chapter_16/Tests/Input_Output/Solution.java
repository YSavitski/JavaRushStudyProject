package com.savitski.thinkingInJava.chapter_16.Tests.Input_Output;

import java.io.*;

/**
 * Created by esavitski on 26.01.2017.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        OutputStream os= new FileOutputStream("name");
        os.write(99);

        PrintWriter pw = new PrintWriter(os);
        pw.write(1);

        /*Console c = System.console();
        char[] cha = c.readPassword();
        String pwd = new String(cha);
        System.out.println("pwd = " + pwd);*/

        FileReader fr = new FileReader("");
        int charRead = 0 ;
        while ((charRead = fr.read()) != -1){
            System.out.println();
        }
    }
}
