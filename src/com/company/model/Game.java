package com.company.model;

public class Game implements Win {

    protected final Board board = new Board();
    protected final Figure figure1;
    protected final Figure figure2;
    protected Figure current;
    private final Rule rule = new Rule();

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
        return rule.isWin(board, current);
    }

    public boolean isDraw() {
        return rule.isDraw(board);
    }

    public char[][] boardCharArray() {
        return board.toCharArray();
    }

    private static class Rule implements Win, Draw {

        @Override
        public boolean isWin(Board board, Figure figure) {
            return Win.super.isWin(board, figure);
        }

        @Override
        public boolean isDraw(Board board) {
            return Draw.super.isDraw(board);
        }

    }

}
