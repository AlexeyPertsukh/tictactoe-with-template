package com.company.model;

public class Command {
    private final String value;

    public Command(String value) {
        this.value = value;
    }

    public boolean isMove() {
        return isInteger(value);
    }

    public int toInt() {
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
