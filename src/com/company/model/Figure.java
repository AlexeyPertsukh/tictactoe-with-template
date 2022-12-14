package com.company.model;

public enum Figure {
    NULL(' '),
    X('X'),
    ZERO('O');

    private final char ch;

    Figure(char ch) {
        this.ch = ch;
    }

    public char getChar() {
        return ch;
    }

    public boolean isNull() {
        return this == NULL;
    }
}
