package com.company.model;

public class Game {

    private final Board board = new Board();
    private final Figure figure1;
    private final Figure figure2;
    private Figure current;

    public Game(Figure figure1, Figure figure2) {
        this.figure1 = figure1;
        this.figure2 = figure2;
        current = figure1;
    }

    public void changeCurrent() {
        current = other();
    }

    private Figure other() {
        return current == figure1 ? figure2 : figure1;
    }

    public void move(int num) {
        board.insert(num, current);
    }

    public char getCurrentChar() {
        return current.getChar();
    }

    public boolean isWin() {
        return Win.isWin(board, current);
    }

    public boolean isDraw() {
        return Draw.isDraw(board);
    }

    public char[][] boardCharArray() {
        return board.toCharArray();
    }
}
