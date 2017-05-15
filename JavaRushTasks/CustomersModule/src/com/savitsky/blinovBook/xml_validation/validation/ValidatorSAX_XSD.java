package com.savitsky.blinovBook.xml_validation.validation;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by esavitski on 15.05.2017.
 */
public class ValidatorSAX_XSD {
    public static String filePath = "D:\\myFolder\\Java\\JavaRush\\JavaRushTasks\\CustomersModule\\src\\com\\savitsky\\blinovBook\\xml_validation\\data\\";
    public static void main(String[] args){
        String xml_filename = "students_ext.xml";
        String xsd_filename = "students.xsd";
        String log_filename = "log.txt";

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File schemaLocation = new File(filePath.concat(xsd_filename));

        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filePath.concat(xml_filename));
            validator.setErrorHandler(new StudentErrorHandler(filePath.concat(log_filename)));
            validator.validate(source);
            System.out.println("This XML is valid");
        } catch (SAXException e) {
            System.err.print("validation "+ xml_filename + " is not valid because " + e.getMessage());
        } catch (IOException e) {
            System.err.print(xml_filename + " is not valid because " + e.getMessage());
        }
    }
}
