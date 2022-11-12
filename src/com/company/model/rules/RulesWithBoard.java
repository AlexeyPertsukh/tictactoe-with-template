package com.company.model.rules;

import com.company.model.board.Board;
import com.company.model.Figure;

public class RulesWithBoard extends Rules{

    public boolean isWin(Board board, Figure figure) {
        int bites = board.bitesOf(figure);
        return super.isWin(bites);
    }

    public int winLine(Board board, Figure figure) {
        int bites = board.bitesOf(figure);
        return super.winLine(bites);
    }

    public boolean isDraw(Board board) {
        return super.isDraw(board.bitesOf(board.getEmptyFigure()));
    }
}
