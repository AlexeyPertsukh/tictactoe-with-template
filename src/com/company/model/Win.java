package com.company.model;

import com.company.model.Board;
import com.company.model.Figure;

public class Win {
    private Win() {
    }

    private static final int[] WINS = new int[]{
            0b000_000_000_111,
            0b000_000_111_000,
            0b000_111_000_000,

            0b000_001_001_001,
            0b000_010_010_010,
            0b000_100_100_100,

            0b000_100_010_001,
            0b000_001_010_100,
    };

    public static boolean isWin(Board board, Figure figure) {
        int num = board.toInt(figure);
        for (int template : WINS) {
            int check = num & template;
            if (check == template) {
                return true;
            }
        }
        return false;
    }
}
