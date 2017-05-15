package com.savitsky.blinovBook.xml_validation.jaxb_marshalization;

import com.example.students.Abiturient;
import com.example.students.Student;
import com.example.students.Students;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

/**
 * Created by esavitski on 15.05.2017.
 */
public class UnMarshalWithXSD {
    public static String filePath = "D:\\myFolder\\Java\\JavaRush\\JavaRushTasks\\CustomersModule\\src\\com\\savitsky\\blinovBook\\xml_validation\\data\\";
    public static void main(String[] args){
        JAXBContext context = null;

        try {
            context = JAXBContext.newInstance("com.example.students");
            Unmarshaller unmarshaller = context.createUnmarshaller();
            String schemaName = "person.xsd";
            String xml_filename = "students_ext.xml";

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation = new File(filePath.concat(schemaName));
            Schema schema = factory.newSchema(schemaLocation);
            unmarshaller.setSchema(schema);

            Students students = (Students) unmarshaller.unmarshal(new File(filePath.concat(xml_filename)));

            students.getPerson().stream().forEach(person -> {
                if(person.getValue() instanceof Abiturient){
                    Abiturient abiturient = (Abiturient) person.getValue();
                    System.out.println(String.format("%s is %s. He/She has %s average mark.",
                            abiturient.getName(), abiturient.getClass().getSimpleName().toLowerCase(), Double.toString(abiturient.getAverageMark())));
                }

                if(person.getValue() instanceof Student){
                    Student student = (Student) person.getValue();
                    System.out.println(String.format("%s is %s. He/She studies at %S faculty.",
                            student.getName(), student.getClass().getSimpleName().toLowerCase(), student.getFaculty()));
                }

            });


        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
