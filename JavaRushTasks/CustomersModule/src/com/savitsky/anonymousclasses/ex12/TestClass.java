package com.savitsky.anonymousclasses.ex12;

/**
 * Created by 07ers on 2/19/2017.
 */
public class TestClass {
    public static void main(String[] args){
        Outer outer = new Outer();
        outer.showValue();
        outer.inner().modifyValue();
        outer.showValue();
    }
}
