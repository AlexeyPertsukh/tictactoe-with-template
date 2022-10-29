package com.company.controller.ai;

import com.company.model.MoveDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AiRandomMove implements Ai{

    // TODO refactor to return int
    @Override
    public String getNextPosition(MoveDto moveDto) {
        List<Integer> possibleMoves = new ArrayList<>();
        int num = 1;
        int free = moveDto.free;
        while (free > 0) {
            if ((free & 1) != 0) {
                possibleMoves.add(num);
            }
            free = free >> 1;
            num++;
        }

        Collections.shuffle(possibleMoves);
        int move = possibleMoves.get(0);
        // TODO try stream realization
        return String.valueOf(move);
    }

}
