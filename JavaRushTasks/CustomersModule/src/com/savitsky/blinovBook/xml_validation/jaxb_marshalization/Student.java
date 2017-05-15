package com.savitsky.blinovBook.xml_jaxb.jaxb_marshalization;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;

/**
 * Created by esavitski on 15.05.2017.
 */
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "Student", propOrder = {
        "name", "telephone", "address"
})
public class Student {
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String login;
    @XmlElement(required = true)
    private String name;
    @XmlAttribute(required = false)
    private String faculty;
    @XmlElement(required = true)
    private int telephone;
    @XmlElement(required = true)
    private Address address;

    public Student() {
    }

    public Student(String login, String name, String faculty, int telephone, Address address) {
        this.login = login;
        this.name = name;
        this.faculty = faculty;
        this.telephone = telephone;
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", telephone=" + telephone +
                ", address=" + address +
                '}';
    }

    @XmlRootElement
    @XmlType(name = "address", propOrder = {
            "city",
            "country",
            "street"
    })
    public static class Address {
        private String country;
        private String city;
        private String street;

        public Address() {
        }

        public Address(String country, String city, String street) {
            this.country = country;
            this.city = city;
            this.street = street;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        @Override
        public String toString() {
            return "\nAddress:" + "\n\tCountry: " + country
                    + "\n\tCity: " + city + "\n\tStreet: " + street + "\n";
        }
    }
}
