package com.savitski.thinkingInJava.chapter_16.serialization.Serialization_Object_OutputStream.Externalizable_examples;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by esavitski on 26.01.2017.
 */
public class Blip_3 implements Externalizable {
    private int i;
    private String s;
    public Blip_3(){
        System.out.println("Blip_3 default constructor");
    }
    public Blip_3(String str, int a){
        System.out.println("Blip_3 customr's constructor");
        this.i = a;
        this.s = str;
    }

    public String toString(){
        return s + Integer.toString(i);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip_3.writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip_3.readExternal");
        s = (String) in.readObject();
        i = in.readInt();
    }
}
