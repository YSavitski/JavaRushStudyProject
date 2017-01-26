package com.savitski.thinkingInJava.chapter_16.serialization.Serialization_Object_OutputStream.Exercises._27;

import java.io.Serializable;

/**
 * Created by esavitski on 26.01.2017.
 */
public class Class_B implements Serializable {
    private char c;
    private Class_A a;

    public Class_B(char c, Class_A a){
        this.c = c;
        this.a = a;
    }

    public String toString(){
        return "Class_B: " + c + " " + a;
    }
}
