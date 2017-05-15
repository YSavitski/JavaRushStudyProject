package com.savitsky.blinovBook.xml_validation.parsingXMLbySAX;

/**
 * Created by esavitski on 15.05.2017.
 */
public enum StudentEnum {

    STUDENTS("students"),
    LOGIN("login"),
    FACULTY("faculty"),
    STUDENT("student"),
    NAME("name"),
    TELEPHONE("telephone"),
    COUNTRY("country"),
    CITY("city"),
    STREET("street"),
    ADDRESS("address");

    private String value;
    private StudentEnum(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
