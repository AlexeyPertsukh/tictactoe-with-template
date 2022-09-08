package com.company.view;

import com.company.model.Board;
import com.company.model.Figure;

public class ConsolePrinter implements Printer {

    private static final String FORMAT = " %c ";

    @Override
    public void print(Board board) {
        int num = 0;
        System.out.println();
        for (int i = 0; i < Board.SIDE; i++) {
            for (int j = 0; j < Board.SIDE; j++) {
                Figure figure = board.get(num);

                char ch = figure == Figure.NULL ? Character.forDigit(num + 1, 10) : figure.getChar();
                System.out.printf(FORMAT, ch);

                if (j < Board.SIDE - 1) {
                    System.out.print("|");
                }
                num++;
            }
            System.out.println();
            if (i < Board.SIDE - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    @Override
    public void print(String string) {
        System.out.print(string);
    }

    @Override
    public void println(String string) {
        System.out.println(string);
    }
}
