package com.savitski.thinkingInJava.chapter_16.serialization.Serialization_Object_OutputStream.Exercises._27;

import java.io.Serializable;

/**
 * Created by esavitski on 26.01.2017.
 */
public class Class_A implements Serializable {
    private int i;

    public Class_A(int i){
        this.i = i;
    }

    public String toString(){
        return "Class_A: " + Integer.toString(i);
    }
}
