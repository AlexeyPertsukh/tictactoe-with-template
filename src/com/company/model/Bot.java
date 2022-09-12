package com.company.model;

public class Bot extends Player{
    private final Ai ai;

    public Bot(Figure figure, Ai ai) {
        super(figure);
        this.ai = ai;
    }

    public String getMove(int free, int myMoves, int enemyMoves) {
        return ai.getMove(free, myMoves, enemyMoves);
    }

}
