package com.company.model;

import com.company.model.Board;
import com.company.model.Figure;

public class Draw {
    private Draw() {
    }

    public static boolean isDraw(Board board) {
        return board.toInt(Figure.NULL) == 0;
    }
}
