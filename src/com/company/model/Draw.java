package com.company.model;

interface Draw {

    default boolean isDraw(Board board) {
        return board.toInt(Figure.NULL) == 0;
    }
}
