package com.savitsky.genericTestpackage;

/**
 * Created by esavitski on 17.04.2017.
 */
public class GenericTestClass {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GenericClass<Integer> gcInt = new GenericClass<>(1);
        /*gcInt.setValue(1);
        int v1 = gcInt.getValue();*/
        System.out.println(gcInt);
    }
}
