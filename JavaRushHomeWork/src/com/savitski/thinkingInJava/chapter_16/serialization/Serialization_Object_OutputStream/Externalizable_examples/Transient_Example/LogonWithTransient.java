package com.savitski.thinkingInJava.chapter_16.serialization.Serialization_Object_OutputStream.Externalizable_examples.Transient_Example;

import javax.swing.*;
import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by esavitski on 26.01.2017.
 */
public class LogonWithTransient implements Serializable {
    private Date dateModify = new Date();
    private String userName = null;
    private transient String password = null;

    public LogonWithTransient(String name, String password){
        this.userName = name;
        this.password = password;
    }
    public String toString() {
        return "logon info: \n   username: " + userName +
                "\n   date: " + dateModify + "\n   password: " + password;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LogonWithTransient user1 = new LogonWithTransient("Yauheni", JOptionPane.showInputDialog("Hello, Yauheni!", "Enter your password"));
        System.out.println("logon user1: " + user1);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("User.pwd"));
        objectOutputStream.writeObject(user1);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("User.pwd"));
        System.out.println(objectInputStream.readObject());

    }
}
