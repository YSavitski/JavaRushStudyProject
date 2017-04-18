package com.savitsky.blinovBook.serialization;

import java.io.*;

/**
 * Created by esavitski on 18.04.2017.
 */
public class Serializator {
    public boolean serialization(Student student, String pathFile){
        boolean flag = false;

        File file = new File(pathFile);
        ObjectOutputStream ostream = null;

        try(FileOutputStream fos = new FileOutputStream(file);) {
            if(fos != null){
                ostream = new ObjectOutputStream(fos);
                ostream.writeObject(student);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NotSerializableException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if (ostream != null){
                    ostream.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public Student deserialization(String pathFile) throws InvalidObjectException {
        File file = new File(pathFile);
        ObjectInputStream istream = null;

        try(FileInputStream fis = new FileInputStream(file)){
            istream = new ObjectInputStream(fis);
            Student student = (Student) istream.readObject();
            return student;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidClassException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(istream != null){
                try {
                    istream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new InvalidObjectException("Object is not restored");
    }
}
