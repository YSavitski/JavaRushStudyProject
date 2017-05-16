package com.savitsky.blinovBook.xml_validation.pasringXMLbyStAX;

import com.example.students.Address;
import com.example.students.Student;
import com.savitsky.blinovBook.xml_validation.parsingXMLbySAX.StudentEnum;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;

/**
 * Created by esavitski on 16.05.2017.
 */
public class StudentsStAXBuilder {
    private HashSet<Student> students =new HashSet<>();
    private XMLInputFactory inputFactory;

    public StudentsStAXBuilder(){
        inputFactory = XMLInputFactory.newInstance();
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public void parseXMLtoSET(String fileName){
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name = null;

        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()){
                int type = reader.next();
                if(type == XMLStreamConstants.START_ELEMENT){
                    name = reader.getLocalName();
                    if(StudentEnum.valueOf(name.toUpperCase()) == StudentEnum.STUDENT){
                        Student student = buildStudent(reader);
                        students.add(student);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File " + fileName + " not found! " + e);
        } catch (XMLStreamException e) {
            System.err.println("StAX parsing error! " + e.getMessage());
        } finally {
            if(inputStream !=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.err.println("Impossible close file "+fileName+" : "+e);
                }
            }
        }
    }

    private Student buildStudent(XMLStreamReader reader) throws XMLStreamException {
        Student student = new Student();
        student.setLogin(reader.getAttributeValue(null, StudentEnum.LOGIN.getValue()));
        student.setFaculty(reader.getAttributeValue(null, StudentEnum.FACULTY.getValue()));

        String name = null;
        while (reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (StudentEnum.valueOf(name.toUpperCase())){
                        case NAME:
                            student.setName(getXMLText(reader));
                            break;
                        case TELEPHONE:
                            student.setTelephone(BigInteger.valueOf(Integer.parseInt(getXMLText(reader))));
                            break;
                        case ADDRESS:
                            student.setAddress(getXMLAddress(reader));
                            break;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(StudentEnum.valueOf(name.toUpperCase())==StudentEnum.STUDENT){
                        return student;
                    }
                    break;
            }
        }

        throw new XMLStreamException("Unknown element in tag Student");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if(reader.hasNext()){
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private Address getXMLAddress(XMLStreamReader reader) throws XMLStreamException {
        Address address = new Address();
        String name = null;

        while (reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (StudentEnum.valueOf(name.toUpperCase())){
                        case COUNTRY:
                            address.setCountry(getXMLText(reader));
                            break;
                        case CITY:
                            address.setCity(getXMLText(reader));
                            break;
                        case STREET:
                            address.setStreet(getXMLText(reader));
                            break;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(StudentEnum.valueOf(name.toUpperCase()) == StudentEnum.ADDRESS){
                        return address;
                    }
                    break;
            }
        }

        throw new XMLStreamException("Unknown element in tag Address");
    }
}
