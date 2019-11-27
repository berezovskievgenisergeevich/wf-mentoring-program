package com.epam.workingWithFiles.lectures.xmlParses.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMParserDemo {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String xmlPath = "src\\com\\epam\\workingWithFiles\\lectures\\xmlParses\\items.xml";
        File input = new File(xmlPath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(input);

        System.out.println("Root element "+document.getDocumentElement().getNodeName());

        NodeList children = document.getElementsByTagName("book");
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            System.out.println(node.getNodeName());

            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                System.out.println("Book id "+element.getAttribute("id"));
                System.out.println("author "+element.getElementsByTagName("author").item(0).getTextContent());

            }

        }


    }
}
