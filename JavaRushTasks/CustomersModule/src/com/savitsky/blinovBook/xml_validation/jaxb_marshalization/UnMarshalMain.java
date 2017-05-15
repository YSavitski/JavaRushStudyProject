package com.savitsky.blinovBook.xml_jaxb.jaxb_marshalization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by esavitski on 15.05.2017.
 */
public class UnMarshalMain {
    public static void main(String[] args){
        try {
            JAXBContext context = JAXBContext.newInstance(Students.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fileReader = new FileReader("D:\\myFolder\\Java\\JavaRush\\JavaRushTasks\\CustomersModule\\src\\com\\savitsky\\blinovBook\\xml_validation\\data\\studs_marsh.xml");

            Students students = (Students) unmarshaller.unmarshal(fileReader);
            System.out.println(students);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
