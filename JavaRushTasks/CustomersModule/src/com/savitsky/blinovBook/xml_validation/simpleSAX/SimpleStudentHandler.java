package com.savitsky.blinovBook.xml_validation.simpleSAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by esavitski on 15.05.2017.
 */
public class SimpleStudentHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started...\n");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("\nParsing ended");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        StringBuilder sBuilder = new StringBuilder(localName);
        for(int i=0; i < attributes.getLength(); i++){
            sBuilder.append(String.format("%s=%s", attributes.getLocalName(i), attributes.getValue(i)).trim());
        }
        System.out.println(sBuilder.toString());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.print(new String(ch, start, length));
    }
}
