package com.savitsky.blinovBook.xml_jaxb.jaxb_marshalization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/**
 * Created by esavitski on 15.05.2017.
 */
public class MarshalMain {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Students.class);
            Marshaller marshaller = context.createMarshaller();


            Students students = new Students() { // анонимный класс
                {
                    Student.Address address = new Student.Address("BLR", "Minsk", "Skoriny 4");
                    Student s = new Student("gochette", "Klimenko", "mmf", 2095306, address);
                    this.add(s);
                    address = new Student.Address("BLR", "Polotesk", "Simeona P. 23");
                    s = new Student("ivette", "Teran", "mmf", 2345386, address);
                    this.add(s);
                }
            };
            marshaller.marshal(students, new FileOutputStream("D:\\myFolder\\Java\\JavaRush\\JavaRushTasks\\CustomersModule\\src\\com\\savitsky\\blinovBook\\xml_validation\\data\\studs_marsh.xml"));
            marshaller.marshal(students, System.out);

            System.out.println("XML-файл создан");
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}
