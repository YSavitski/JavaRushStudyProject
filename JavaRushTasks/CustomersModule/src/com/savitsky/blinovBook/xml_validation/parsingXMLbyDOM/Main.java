package com.savitsky.blinovBook.xml_validation.parsingXMLbyDOM;

/**
 * Created by 07ers on 5/16/2017.
 */
public class Main {
    private static String filePath = System.getProperty("user.dir").concat("\\CustomersModule\\src\\com\\savitsky\\blinovBook\\xml_validation\\data\\");
    public static void main(String[] args){
        StudentsDOMBuilder domBuilder = new StudentsDOMBuilder();
        domBuilder.parseXMLtoSET(filePath.concat("students.xml"));
        domBuilder.getStudents().stream().forEach(student -> {
            System.out.println(String.format("%s is student. He/She studies at %S faculty. His/her login is %s. Phone: %s."/* \nAddress: %s, %s, %s."*/,
                    student.getName(), student.getFaculty(), student.getLogin(), student.getTelephone()/*,
                    student.getAddress().getCountry(), student.getAddress().getCity(), student.getAddress().getStreet()*/));
        });
    }
}
