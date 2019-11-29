package com.epam.workingWithFiles.lectures.xmlParses.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXParserDemo {
    public static void main(String[] args) {

        String xmlPath = "src\\com\\epam\\workingWithFiles\\lectures\\xmlParses\\items.xml";
        File input = new File(xmlPath);

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(input, new BookHandler());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
