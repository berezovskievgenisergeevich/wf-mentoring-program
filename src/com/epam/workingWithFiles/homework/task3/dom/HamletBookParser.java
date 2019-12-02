package com.epam.workingWithFiles.homework.task3.dom;

import com.epam.workingWithFiles.homework.task3.model.Play;
import com.epam.workingWithFiles.homework.task3.model.PlayModel;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class HamletBookParser {
    private String filePath;
    private Document document;

    public HamletBookParser(String filePath) throws ParserConfigurationException, IOException, SAXException {
        this.filePath = filePath;
        File input = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(input);
    }

    public PlayModel parse() {
        PlayModel playModel = new PlayModel();

        fillList(Play.SCNDESCR.name(), playModel.scndescr);
        fillList(Play.LINE.name(), playModel.line);
        fillList(Play.PERSONA.name(), playModel.persona);
        fillList(Play.P.name(), playModel.p);
        fillList(Play.FM.name(), playModel.fm);
        fillList(Play.SPEAKER.name(), playModel.speaker);
        fillList(Play.ACT.name(), playModel.act);
        fillList(Play.TITLE.name(), playModel.titles);

        return playModel;
    }

    private void fillList(String tagName, List<String> list) {
        NodeList children = document.getElementsByTagName(tagName);
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            list.add(node.getTextContent());
        }
    }

}
