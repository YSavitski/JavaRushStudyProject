package com.savitsky.blinovBook.serialization;

import java.io.InvalidObjectException;

/**
 * Created by esavitski on 18.04.2017.
 */
public class SerializeRunner {
    public static void main(String[] args){
        Student student = new Student("MMF", "Eugeny", 1, "FyzRhenmrj16");
        System.out.println(student);
        String pathFile = "data.data";
        Serializator serializator = new Serializator();
        //boolean serialised = serializator.serialization(student, pathFile);
        //System.out.println(serialised);

        Student.faculty = "GEO";
        Student restoredStudent = null;
        try {
            restoredStudent = serializator.deserialization(pathFile);
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }

        System.out.println(restoredStudent);
    }
}
