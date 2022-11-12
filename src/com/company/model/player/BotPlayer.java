package com.company.model.player;

import com.company.model.Figure;
import com.company.model.Moves;
import com.company.model.ai.Ai;

public class BotPlayer extends Player {
    private final Ai ai;

    public BotPlayer(Figure figure, Ai ai) {
        super(figure);
        this.ai = ai;
    }

    public int nextMove(Moves moves) {
        return ai.nextMove(moves);
    }

    @Override
    public String getName() {
        return super.getName() + "[bot]";
    }
}
