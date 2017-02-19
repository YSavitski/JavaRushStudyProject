package com.savitsky.anonymousclasses.ex12;

/**
 * Created by 07ers on 2/19/2017.
 */
public class Outer {
    private int i = 1;
    private void hi(){
        System.out.println("hi");
    }

    public InnerInterface inner(){
        return new InnerInterface() {
            @Override
            public void modifyValue() {
                i++;
                hi();
            }
        };
    }

    public void showValue(){
        System.out.println(i);
    }
}
