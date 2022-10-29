package com.company.model.player;

import com.company.model.Figure;

public class Player {
    private final Figure figure;

    public Player(Figure figure) {
        this.figure = figure;
    }

    public Figure getFigure() {
        return figure;
    }

    public String getName() {
        return String.valueOf(figure.getChar());
    }

}
