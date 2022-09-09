package com.company.model;

class Draw {

    private Draw() {
    }

    public static boolean isDraw(Board board) {
        return board.toInt(Figure.NULL) == 0;
    }
}
