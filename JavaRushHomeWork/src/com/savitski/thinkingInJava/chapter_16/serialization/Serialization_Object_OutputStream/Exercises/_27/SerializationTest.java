package com.savitski.thinkingInJava.chapter_16.serialization.Serialization_Object_OutputStream.Exercises._27;

import java.io.*;
import java.util.Random;

/**
 * Created by esavitski on 26.01.2017.
 */
public class SerializationTest implements Serializable {
    private static Random rand = new Random();
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Class_B b = new Class_B('x', new Class_A(rand.nextInt(100)));
        System.out.println("b: " + b);

        ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("STest.txt"));
        outStream.writeObject(b);
        outStream.close();

        ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("STest.txt"));
        System.out.println("new b: " + (Class_B)inStream.readObject());
    }

}
