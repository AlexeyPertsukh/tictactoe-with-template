package com.company.model.player;

import com.company.model.Figure;
import com.company.model.Moves;
import com.company.model.ai.Ai;

public class Bot extends Player{
    private final Ai ai;

    public Bot(Figure figure, Ai ai) {
        super(figure);
        this.ai = ai;
    }

    public String nextMove(Moves moves) {
        return ai.nextMove(moves);
    }

    @Override
    public String getName() {
        return super.getName() + "[bot]";
    }
}
