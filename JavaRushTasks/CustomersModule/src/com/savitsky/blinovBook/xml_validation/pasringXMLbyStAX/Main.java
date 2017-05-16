package com.savitsky.blinovBook.xml_validation.pasringXMLbyStAX;

/**
 * Created by esavitski on 16.05.2017.
 */
public class Main {
    private static String filePath = System.getProperty("user.dir").concat("\\CustomersModule\\src\\com\\savitsky\\blinovBook\\xml_validation\\data\\");
    public static void main(String[] args){
        StudentsStAXBuilder staxBuilder = new StudentsStAXBuilder();
        staxBuilder.parseXMLtoSET(filePath.concat("students.xml"));
        staxBuilder.getStudents().stream().forEach(student -> {
            System.out.println(String.format("%s is student. He/She studies at %S faculty. His/her login is %s. Phone: %s. \nAddress: %s, %s, %s.",
                    student.getName(), student.getFaculty(), student.getLogin(), student.getTelephone(),
                    student.getAddress().getCountry(), student.getAddress().getCity(), student.getAddress().getStreet()));
        });
    }
}
