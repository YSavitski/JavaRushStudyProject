package com.savitsky.blinovBook.xml_validation.validation;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;


/**
 * Created by esavitski on 15.05.2017.
 */
public class StudentErrorHandler extends DefaultHandler {
    private Logger logger = Logger.getLogger("com.savitsky.blinovBook.xml_validation.validation");

    public StudentErrorHandler(String log) throws IOException {
        logger.addAppender(new FileAppender(new SimpleLayout(), log));
    }

    public void warning(SAXParseException e) {
        logger.warn(getLineAddress(e) + " - " + e.getMessage());
    }

    public void error(SAXParseException e){
        logger.error(getLineAddress(e) + " - " + e.getMessage());
    }

    public void fatalError(SAXParseException e){
        logger.fatal(getLineAddress(e) + " - " + e.getMessage());
    }

    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
