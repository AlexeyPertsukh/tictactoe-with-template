package com.company.model;

public class Command {
    private static final String END = "end";
    private static final String HELP = "?";
    private final String value;

    public Command(String value) {
        this.value = value;
    }

    public boolean isMove() {
        return isInteger(value);
    }

    public boolean isEnd() {
        return value.equalsIgnoreCase(END);
    }

    public boolean isHelp() {
        return value.equalsIgnoreCase(HELP);
    }

    public int getMove() {
        return Integer.parseInt(value);
    }

    private static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public String getValue() {
        return value;
    }
}
