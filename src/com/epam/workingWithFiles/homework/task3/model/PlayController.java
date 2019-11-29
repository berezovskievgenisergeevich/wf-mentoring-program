package com.epam.workingWithFiles.homework.task3.model;

public class PlayController {
    public static boolean isItTitle(String title) {
        return title.equals(Play.TITLE.name());
    }

    public static boolean isItAct(String act) {
        return act.equals(Play.ACT.name());
    }

    public static boolean isItSpeaker(String speaker) {
        return speaker.equals(Play.SPEAKER.name());
    }

    public static boolean isItLine(String line) {
        return line.equals(Play.LINE.name());
    }

    public static boolean isItFm(String fm) {
        return fm.equals(Play.FM.name());
    }

    public static boolean isItP(String p) {
        return p.equals(Play.P.name());
    }

    public static boolean isItPersona(String persona) {
        return persona.equals(Play.PERSONA.name());
    }

    public static boolean isItScndescr(String scndescr) {
        return scndescr.equals(Play.SCNDESCR.name());
    }
}
