package com.company.view;

import com.company.model.Board;
import com.company.model.Figure;

public class ConsolePrinter implements Printer {

    private static final String FORMAT = " %c ";

    @Override
    public void printBoard(char[][] boardCharArray) {
        int num = 1;
        System.out.println();
        for (int i = 0; i < boardCharArray.length; i++) {
            for (int j = 0; j < boardCharArray[i].length; j++) {
                char ch = boardCharArray[i][j];
                if(ch == Figure.NULL.getChar()) {
                    ch = Character.forDigit(num, 10);
                }
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
