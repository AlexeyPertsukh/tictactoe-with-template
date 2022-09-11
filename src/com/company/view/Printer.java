package com.company.view;

import com.company.model.Board;

public interface Printer {

    void printBoard(char[][] boardCharArray);
    void printBoard(char[][] boardCharArray, int winLine);

    void print(String string);
    void println(String string);
}
