package com.savitsky.blinovBook.xml_validation.simpleSAX;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Created by esavitski on 15.05.2017.
 */
public class SAXSimpleMain {
    public static String filePath = "D:\\myFolder\\Java\\JavaRush\\JavaRushTasks\\CustomersModule\\src\\com\\savitsky\\blinovBook\\xml_validation\\data\\";
    public static void main(String[] args){
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SimpleStudentHandler handler = new SimpleStudentHandler();
            reader.setContentHandler(handler);
            reader.parse(filePath.concat("students.xml"));
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока " + e);
        }
    }
}
