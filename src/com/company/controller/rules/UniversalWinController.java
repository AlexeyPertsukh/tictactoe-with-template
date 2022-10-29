package com.company.controller.rules;

import com.company.model.Board;
import com.company.model.Figure;

public class UniversalWinController {

    private UniversalWinController() {
    }

    private static final int[] WIN_TEMPLATES = new int[]{
            0b000_000_000_111,
            0b000_000_111_000,
            0b000_111_000_000,

            0b000_001_001_001,
            0b000_010_010_010,
            0b000_100_100_100,

            0b000_100_010_001,
            0b000_001_010_100,
    };

     public static boolean isWin(int binaryBoardRepresentationConcretePlayer) {
        return winLine(binaryBoardRepresentationConcretePlayer) != 0;
    }

    public static int winLine(int num) {
        for (int template : WIN_TEMPLATES) {
            int check = num & template;
            if (check == template) {
                return template;
            }
        }

        return 0;
    }

}
