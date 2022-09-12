package com.company.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AiRandomMove implements Ai{

    @Override
    public String getMove(int free, int myMoves, int enemyMoves) {
        List<Integer> possibleMoves = new ArrayList<>();
        int num = 1;
        while (free > 0) {
            if ((free & 1) != 0) {
                possibleMoves.add(num);
            }
            free = free >> 1;
            num++;
        }

        Collections.shuffle(possibleMoves);
        int move = possibleMoves.get(0);
        return String.valueOf(move);
    }
}
