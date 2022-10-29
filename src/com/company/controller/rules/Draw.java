package com.company.controller.rules;

import com.company.model.Board;
import com.company.model.Figure;

public class Draw {

    private Draw() {
    }

    public static boolean isDraw(Board board) {
        return board.figureMovesInBits(Figure.NULL) == 0;
    }
}
