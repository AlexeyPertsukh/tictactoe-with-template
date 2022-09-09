package com.company.model;

interface Win {

    int[] WIN_TEMPLATES = new int[]{
            0b000_000_000_111,
            0b000_000_111_000,
            0b000_111_000_000,

            0b000_001_001_001,
            0b000_010_010_010,
            0b000_100_100_100,

            0b000_100_010_001,
            0b000_001_010_100,
    };

     default boolean isWin(Board board, Figure figure) {
        int num = board.toInt(figure);
        for (int template : WIN_TEMPLATES) {
            int check = num & template;
            if (check == template) {
                return true;
            }
        }
        return false;
    }
}
