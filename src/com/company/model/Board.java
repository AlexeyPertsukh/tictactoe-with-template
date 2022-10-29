package com.company.model;

import com.company.model.exception.GameException;

import java.util.Arrays;

public class Board {
    public static final int SIDE = 3;

    protected final Figure[] array = new Figure[SIDE * SIDE];

    public Board() {
        Arrays.fill(array, Figure.NULL);
    }

    public void insert(int position, Figure figure) {

        if (position < 0 || position >= array.length) {
            throw new GameException("illegal cell address");
        }

        if (!get(position).isNull()) {
            throw new GameException("you can't go to this cell, it's busy");
        }
        array[position] = figure;
    }

    public Figure get(int num) {
        return array[num];
    }

    // TODO move to BoardController
    // TODO rename better
    public int figureMovesInBits(Figure figure) {
        int out = 0;
        int mask = 1;
        for (Figure value : array) {
            if (value == figure) {
                out = out | mask;  // 1011 = 1000 | 0011   // 1 or 0  = 1
            }
            mask = mask << 1;
        }
        return out;
    }

    public char[][] toCharArray() {
        char[][] out = new char[SIDE][SIDE];
        for (int i = 0; i < array.length; i++) {
            out[i / SIDE][i % SIDE] = array[i].getChar();
        }
        return out;
    }

}
