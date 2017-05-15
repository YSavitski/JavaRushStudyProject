package com.savitsky.blinovBook.xml_validation.parsingXMLbySAX;

import com.example.students.Address;
import com.example.students.Student;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigInteger;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by esavitski on 15.05.2017.
 */
public class StudentHandler extends DefaultHandler {
    private Set<Student> students;
    private Student currentStudent = null;
    private StudentEnum currentEnum = null;
    private EnumSet<StudentEnum> withText;

    public StudentHandler(){
        students = new HashSet<>();
        withText = EnumSet.range(StudentEnum.NAME, StudentEnum.STREET);
    }

    public Set<Student> getStudents(){
        return students;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("student".equals(localName)) {
            currentStudent = new Student();
            currentStudent.setLogin(attributes.getValue(0));
            if (attributes.getLength() == 2) {
                currentStudent.setFaculty(attributes.getValue(1));
            }
        } else {
            StudentEnum temp = StudentEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("student".equals(localName)) {
            students.add(currentStudent);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String str = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum){
                case NAME:
                    currentStudent.setName(str);
                    break;
                case TELEPHONE:
                    currentStudent.setTelephone(BigInteger.valueOf(Integer.parseInt(str)));
                    break;
                case STREET:
                    if(currentStudent.getAddress() == null){
                        currentStudent.setAddress(new Address());
                        currentStudent.getAddress().setStreet(str);
                    } else {
                        currentStudent.getAddress().setStreet(str);
                    }
                    break;
                case CITY:
                    if(currentStudent.getAddress() == null){
                        currentStudent.setAddress(new Address());
                        currentStudent.getAddress().setCity(str);
                    } else {
                        currentStudent.getAddress().setCity(str);
                    }
                    break;
                case COUNTRY:
                    if(currentStudent.getAddress() == null){
                        currentStudent.setAddress(new Address());
                        currentStudent.getAddress().setCountry(str);
                    } else {
                        currentStudent.getAddress().setCountry(str);
                    }
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
