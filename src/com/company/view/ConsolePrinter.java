package com.company.view;

import com.company.model.Board;
import com.company.model.Figure;

public class ConsolePrinter implements Printer {

    private static final String BASIC_FORMAT = " %c ";
    private static final String WIN_FORMAT = "<%c>";

    @Override
    public void printBoard(char[][] boardCharArray) {
        printBoard(boardCharArray, 0);
    }

    @Override
    public void printBoard(char[][] boardCharArray, int winLine) {
        int num = 1;
        int mask = 1;
        System.out.println();
        for (int i = 0; i < boardCharArray.length; i++) {
            for (int j = 0; j < boardCharArray[i].length; j++) {
                char ch = boardCharArray[i][j];
                if (ch == Figure.NULL.getChar()) {
                    ch = Character.forDigit(num, 10);
                }
                String format = getFormat(winLine, mask);
                mask = mask << 1;

                System.out.printf(format, ch);

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

    private static String getFormat(int winLine, int mask) {
        return (winLine & mask) == 0 ? BASIC_FORMAT : WIN_FORMAT;
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
