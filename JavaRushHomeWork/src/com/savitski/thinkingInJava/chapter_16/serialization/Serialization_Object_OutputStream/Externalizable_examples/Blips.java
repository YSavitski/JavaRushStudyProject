package com.savitski.thinkingInJava.chapter_16.serialization.Serialization_Object_OutputStream.Externalizable_examples;

import java.io.*;

/**
 * Created by esavitski on 26.01.2017.
 */
public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Create objects...");
        //Blip_1 b1 = new Blip_1();
        //Blip_2 b2 = new Blip_2();
        Blip_3 b3 = new Blip_3("A String ", 47);

        //System.out.println(b1 + "\n" + b2 + "\n" + b3);
        System.out.println(b3);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("Saving object");
        o.writeObject(b3);
        o.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("Recovering object");
        Blip_3 new_b3 = (Blip_3) in.readObject();
        System.out.println(new_b3);
    }
}
