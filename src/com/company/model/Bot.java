package com.company.model;

public class Bot extends Player{
    private final Ai ai;

    public Bot(Figure figure, Ai ai) {
        super(figure);
        this.ai = ai;
    }

    public String getMove(Moves moves) {
        return ai.getMove(moves);
    }

    @Override
    public String getName() {
        return super.getName() + "[bot]";
    }
}
