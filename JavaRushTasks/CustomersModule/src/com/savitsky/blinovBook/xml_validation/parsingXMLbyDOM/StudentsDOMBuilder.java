package com.savitsky.blinovBook.xml_validation.parsingXMLbyDOM;

import com.example.students.Address;
import com.example.students.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 07ers on 5/16/2017.
 */
public class StudentsDOMBuilder {
    private Set<Student> students;
    private DocumentBuilder docBuilder;

    public StudentsDOMBuilder(){
        this.students = new HashSet<Student>();
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void parseXMLtoSET(String fileName){
        Document doc = null;

        try {
            doc = docBuilder.parse(fileName);
            Element rootElement = doc.getDocumentElement();
            NodeList childStudentElements = rootElement.getElementsByTagName("student");

            for(int i=0; i<childStudentElements.getLength(); i++){
                Element studentElement = (Element) childStudentElements.item(i);
                Student student = buildStudent(studentElement);
                students.add(student);
            }
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        }
    }

    private Student buildStudent(Element studentElement){
        Student student = new Student();

        student.setLogin(studentElement.getAttribute("login"));
        student.setFaculty(studentElement.getAttribute("faculty"));

        student.setName(getElementTextContent(studentElement, "name"));

        BigInteger telephone = BigInteger.valueOf(Integer.parseInt(getElementTextContent(studentElement, "telephone")));
        student.setTelephone(telephone);

        Address address = student.getAddress();
        Element addressElement = (Element) studentElement.getElementsByTagName("address").item(0);
        address.setCountry(getElementTextContent(addressElement, "country"));
        address.setCity(getElementTextContent(addressElement, "city"));
        address.setStreet(getElementTextContent(addressElement, "street"));

        return student;
    }

    private static String getElementTextContent(Element element, String elementName){
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
