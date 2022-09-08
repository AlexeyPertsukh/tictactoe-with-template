package com.company.model;

public class Command {
    private final String string;

    public Command(String string) {
        this.string = string;
    }

    public boolean isMove() {
        return isInteger(string);
    }

    public int toInt() {
        return Integer.parseInt(string);
    }

    private static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
