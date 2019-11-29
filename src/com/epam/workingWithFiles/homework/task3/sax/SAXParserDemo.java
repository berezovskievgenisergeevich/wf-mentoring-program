package com.epam.workingWithFiles.homework.task3.sax;

import com.epam.workingWithFiles.homework.task3.model.PlayModel;
import com.epam.workingWithFiles.homework.task3.utils.Info;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXParserDemo {
    public static void main(String[] args) {
        File input = new File(Info.FILE_PATH);

        SAXParserFactory factory = SAXParserFactory.newInstance();


        PlayModel playModel = new PlayModel();
        HamletBookHandler handler = new HamletBookHandler(playModel);
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(input, handler);
            playModel.p.forEach(System.out::println);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
