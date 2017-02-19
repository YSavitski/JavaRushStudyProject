package com.savitsky.innerclasses;

import javax.net.ssl.SSLContext;

/**
 * Created by 07ers on 2/19/2017.
 */
public class Outer {
    private String field;

    public Outer(){
        this.field = "test string";
    }

    private class Inner{
        public String toString(){
            return Outer.this.field;
        }
    }
    public Inner getInnerClass(){
        return new Inner();
    }



    public static void main(String[] args){
        Outer outer = new Outer();
        Outer.Inner inner = outer.getInnerClass();

        System.out.println(outer.getClass().getName());
        System.out.println(inner.getClass().getName());
        System.out.println(inner.toString());
    }
}
