package com.epam.workingWithFiles.homework.task3.dom;

import com.epam.workingWithFiles.homework.task3.utils.Info;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParserDemo {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String xmlPath = Info.FILE_PATH;

        HamletBookParser bookParser = new HamletBookParser(xmlPath);

        bookParser.parse().line.forEach(System.out::println);

    }
}
