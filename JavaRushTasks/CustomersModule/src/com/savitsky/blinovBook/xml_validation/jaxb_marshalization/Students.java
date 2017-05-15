package com.savitsky.blinovBook.xml_jaxb.jaxb_marshalization;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by esavitski on 15.05.2017.
 */
@XmlRootElement
public class Students {
    @XmlElement(name="student")
    private ArrayList<Student> list = new ArrayList<Student>();
    public Students() {
        super();
    }
    public void setList(ArrayList<Student> list) {
        this.list = list;
    }
    public boolean add(Student st) {
        return list.add(st);
    }
    @Override
    public String toString() {
        return "Students [list=" + list + "]";
    }
}
