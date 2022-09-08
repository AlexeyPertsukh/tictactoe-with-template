package com.company.model;

public class Draw {
    private Draw() {
    }

    public static boolean isDraw(Board board) {
        return board.toInt(Figure.NULL) == 0;
    }
}
