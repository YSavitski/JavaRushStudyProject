package com.savitski.thinkingInJava.chapter_16.serialization.Serialization_Object_OutputStream.Externalizable_examples.Transient_Example;

import javax.swing.*;
import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by esavitski on 26.01.2017.
 */
public class LogonImlemExternazible  implements Externalizable{
    private Date dateModify = new Date();
    private String username = null;
    private String password = null;

    public LogonImlemExternazible(){
        this.username = null;
        this.password = null;
        this.dateModify = new Date();
    }

    public LogonImlemExternazible(String name, String password){
        this.username = name;
        this.password = password;
    }
    public String toString() {
        return "logon info: \n   username: " + username +
                "\n   date: " + dateModify + "\n   password: " + password;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.dateModify);
        out.writeObject(this.username);
        out.writeObject(this.password);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.dateModify = new Date();
        in.readObject();
        this.username = (String)in.readObject();
        in.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LogonImlemExternazible user1 = new LogonImlemExternazible("Yauheni", JOptionPane.showInputDialog("Hello, Yauheni!", "Enter your password"));
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
