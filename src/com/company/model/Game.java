package com.company.model;

public class Game {

    private final Board board;
    private final Figure figure1;
    private final Figure figure2;
    private Figure current;

    public Game(Board board, Figure figure1, Figure figure2) {
        this.board = board;
        this.figure1 = figure1;
        this.figure2 = figure2;
        current = figure1;
    }

    public Figure getCurrent() {
        return current;
    }

    public Board getBoard() {
        return board;
    }

    public Figure other() {
        return current == figure1 ? figure2 : figure1;
    }

    public void changeCurrent() {
        current = other();
    }

    public void move(int num) {
        board.insert(num, current);
    }

    public char getCurrentChar() {
        return current.getChar();
    }

}
