package com.savitski.thinkingInJava.chapter_16.serialization.Serialization_Object_OutputStream.Externalizable_examples;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by esavitski on 26.01.2017.
 */
public class Blip_1 implements Externalizable {
    public Blip_1(){
        System.out.println("Blip_1 default constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip_1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip_1.readExternal");
    }
}
