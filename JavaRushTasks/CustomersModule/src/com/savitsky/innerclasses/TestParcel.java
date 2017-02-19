package com.savitsky.innerclasses;

/**
 * Created by 07ers on 2/19/2017.
 */
public class TestParcel {
    public static void main(String[] args){
        Parcel parcel = new Parcel();
        Contents contents = parcel.contents();
        Destination destination = parcel.destination("test destination");
        System.out.println(destination.readLabel());
        System.out.println(contents.value());
    }
}
