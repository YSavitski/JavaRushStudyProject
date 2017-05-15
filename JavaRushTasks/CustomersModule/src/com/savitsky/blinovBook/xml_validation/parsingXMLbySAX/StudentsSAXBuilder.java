package com.savitsky.blinovBook.xml_validation.parsingXMLbySAX;

import com.example.students.Student;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

/**
 * Created by esavitski on 15.05.2017.
 */
public class StudentsSAXBuilder {
    private Set<Student> students;
    private StudentHandler studentHandler;
    private XMLReader xmlReader;

    public StudentsSAXBuilder(){
        studentHandler = new StudentHandler();

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(studentHandler);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }

    public Set<Student> getStudents(){
        return students;
    }

    public void parseXMLtoSET(String fileName){
        try {
            xmlReader.parse(fileName);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }

        students = studentHandler.getStudents();
    }
}
