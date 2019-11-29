package com.epam.workingWithFiles.homework.task3.sax;

import com.epam.workingWithFiles.homework.task3.model.PlayModel;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

import static com.epam.workingWithFiles.homework.task3.model.PlayController.*;

public class HamletBookHandler extends DefaultHandler {

    private PlayModel playModel;

    Set<String> strings = new HashSet<>();
    String currentTeg = "";
    private String resultData = "";

    public HamletBookHandler(PlayModel playModel) {
        this.playModel = playModel;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentTeg = qName;
        if (isItTitle(currentTeg)) {
            titleHasAuthorInAttribute(attributes);
        }


    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length);
        if (isItTitle(currentTeg))
            addTitle(data);
        else if (isItAct(currentTeg))
            addAct(data);
        else if (isItSpeaker(currentTeg))
            addSpeaker(data);
        else if (isItLine(currentTeg))
            addLine(data);
        else if (isItFm(currentTeg))
            addFm(data);
        else if (isItP(currentTeg))
            addP(data);
        else if (isItPersona(currentTeg))
            addPersona(data);
        else if (isItScndescr(currentTeg))
            addScndescr(data);

    }

    private void addScndescr(String data) {
        playModel.scndescr.add(data);
    }

    private void addPersona(String data) {
        playModel.persona.add(data);
    }

    private void addP(String data) {
        playModel.p.add(data);
    }

    private void addFm(String data) {
        playModel.fm.add(data);
    }

    private void addLine(String data) {
        playModel.line.add(data);
    }

    private void addSpeaker(String data) {
        playModel.speaker.add(data);
    }

    private void addAct(String data) {
        playModel.act.add(data);
    }

    private void addTitle(String data) {
        playModel.titles.add(data + resultData);
    }

    private void titleHasAuthorInAttribute(Attributes attributes) {
        if (attributes.getValue("AUTHOR") != null) {
            resultData = "AUTHOR is:" + attributes.getValue("AUTHOR");
        } else {
            resultData = "";
        }
    }

    public void printTags() {
        strings.forEach(System.out::println);
    }
}
