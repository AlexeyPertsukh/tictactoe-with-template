package com.company.model.rules;

public class Rules {

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

    public boolean isWin(int bitsPlayerMoves) {
        return winLine(bitsPlayerMoves) != 0;
    }

    public int winLine(int bitsPlayerMoves) {
        for (int template : WIN_TEMPLATES) {
            int check = bitsPlayerMoves & template;
            if (check == template) {
                return template;
            }
        }

        return 0;
    }

    public boolean isDraw(int bitsFreeMoves) {
        return bitsFreeMoves == 0;
    }

}
