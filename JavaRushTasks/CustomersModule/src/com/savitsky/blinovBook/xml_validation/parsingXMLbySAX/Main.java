package com.savitsky.blinovBook.xml_validation.parsingXMLbySAX;

/**
 * Created by esavitski on 15.05.2017.
 */
public class Main {
    private static String filePath = "D:\\myFolder\\Java\\JavaRush\\JavaRushTasks\\CustomersModule\\src\\com\\savitsky\\blinovBook\\xml_validation\\data\\";
    public static void main(String[] args){
        StudentsSAXBuilder saxBuilder = new StudentsSAXBuilder();
        saxBuilder.parseXMLtoSET(filePath.concat("students.xml"));
        saxBuilder.getStudents().stream().forEach(student -> {
            System.out.println(String.format("%s is student. He/She studies at %S faculty. His/her login is %s. Phone: %s. \nAddress: %s, %s, %s.",
                    student.getName(), student.getFaculty(), student.getLogin(), student.getTelephone(),
                    student.getAddress().getCountry(), student.getAddress().getCity(), student.getAddress().getStreet()));
        });
    }
}
