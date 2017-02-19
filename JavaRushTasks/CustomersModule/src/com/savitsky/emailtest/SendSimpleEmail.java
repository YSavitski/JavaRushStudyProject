package com.savitsky.emailtest;

import java.util.Properties;

/**
 * Created by 07ers on 2/16/2017.
 */
public class SendSimpleEmail {
    public static void main(String[] args){
        String recipient = "07ersh@gmail.com";
        String sender = "esavitsky@ascendix.com";
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        //Session session = Session
    }
}
