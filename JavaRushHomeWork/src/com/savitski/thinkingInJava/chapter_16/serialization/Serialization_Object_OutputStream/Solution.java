package com.savitski.thinkingInJava.chapter_16.serialization.Serialization_Object_OutputStream;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by esavitski on 24.01.2017.
 */
public class Solution {

    private static ArrayList<Profile> profiles = new ArrayList<>();

    public static void main(String[] args){
        profiles = (ArrayList<Profile>) deserData("profiles");
        System.out.println(profiles.size());
        /*for (Profile prof :
             profiles) {
            System.out.println(prof.getName() + " " + prof.getSurname());
        }*/
        Profile profile = new Profile();
        profile.setName(JOptionPane.showInputDialog(null, "Enter your name"));
        profile.setSurname(JOptionPane.showInputDialog(null, "Enter your surname"));
        if(profiles.size() > 0){
            profile.setFriend(profiles.get(profiles.size()-1));
        }


        profiles.add(profile);
        for (Profile p:
             profiles) {
            Profile friend =p.getFriend();
            System.out.println(p.getName()+" "+p.getSurname()+". Friend: "+ (friend!=null ? friend.getName() + " " + friend.getSurname() : "No friend"));
            friend = null;
        }
        System.out.println(profiles.size());
        serData("profiles", profiles);
    }

    public static void serData(String file_name, Object obj){
        try {
            FileOutputStream fileOut = new FileOutputStream(file_name+".ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(obj);
            fileOut.close();
            objOut.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
        System.out.println("IOException");
        e.printStackTrace();
        System.exit(2);
        }
    }

    public static Object deserData(String file_name){
        Object retObject = null;
        try {
            FileInputStream fileIn = new FileInputStream(file_name+".ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            retObject = objIn.readObject();
            fileIn.close();
            objIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
            System.exit(2);
        } catch (ClassNotFoundException e){
            System.out.println("Class not found");
            e.printStackTrace();
            System.exit(3);
        }
        return retObject==null? new ArrayList<Profile>() : retObject;
    }


}
