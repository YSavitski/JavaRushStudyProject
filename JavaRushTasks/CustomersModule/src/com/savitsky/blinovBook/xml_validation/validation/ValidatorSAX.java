package com.savitsky.blinovBook.xml_validation.validation;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by esavitski on 15.05.2017.
 */
public class ValidatorSAX {
    public static String filePath = "D:\\myFolder\\Java\\JavaRush\\JavaRushTasks\\CustomersModule\\src\\com\\savitsky\\blinovBook\\xml_validation\\data\\";
    public static void main(String[] args){
        String xml_filename = "students_ext.xml";
        String xsd_filename = "students.xsd";
        String log_filename = "log.txt";

        Schema schema = null;
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        try {
            schema = factory.newSchema(new File(filePath.concat(xsd_filename)));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser parser = spf.newSAXParser();
            parser.parse(filePath.concat(xml_filename), new StudentErrorHandler(filePath.concat(log_filename)));
            System.out.println("This XML is valid");
        } catch (SAXException e) {
            System.err.println(xml_filename + " config error: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.err.println(xml_filename + " SAX error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
