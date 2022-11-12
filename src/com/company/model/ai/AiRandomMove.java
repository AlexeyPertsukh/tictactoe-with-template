package com.company.model.ai;

import com.company.model.Moves;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AiRandomMove implements Ai{

    // TODO refactor to return int
    @Override
    public int nextMove(Moves moves) {
        List<Integer> possibleMoves = new ArrayList<>();
        int num = 1;
        int free = moves.free;
        while (free > 0) {
            if ((free & 1) != 0) {
                possibleMoves.add(num);
            }
            free = free >> 1;
            num++;
        }

        Collections.shuffle(possibleMoves);
        int move = possibleMoves.get(0);
        return move;
    }

}
