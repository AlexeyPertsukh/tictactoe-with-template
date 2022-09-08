package com.company.controller;

import com.company.model.Board;
import com.company.model.Figure;

public class DrawController {
    private DrawController() {
    }

    public static boolean isDraw(Board board) {
        return board.toInt(Figure.NULL) == 0;
    }
}
