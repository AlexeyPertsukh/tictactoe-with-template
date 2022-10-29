package com.company.model.player;

import com.company.model.Figure;
import com.company.model.MoveDto;
import com.company.controller.ai.Ai;

public class BotPlayer extends Player {
    private final Ai ai;

    public BotPlayer(Figure figure, Ai ai) {
        super(figure);
        this.ai = ai;
    }

    public String nextMove(MoveDto moveDto) {
        return ai.getNextPosition(moveDto);
    }

    @Override
    public String getName() {
        return super.getName() + "[bot]";
    }
}
