package com.company.model;

public class Game {

    protected final Board board = new Board();
    protected final Player player1;
    protected final Player player2;
    protected Player current;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        current = player1;
    }

    public void changeCurrent() {
        current = other();
    }

    private Player other() {
        return current == player1 ? player2 : player1;
    }

    public void move(int num) {
        board.insert(num, current.getFigure());
    }

    public char getCurrentChar() {
        return current.getChar();
    }

    public boolean isWin() {
        return Win.isWin(board, current.getFigure());
    }

    public boolean isDraw() {
        return Draw.isDraw(board);
    }

    public int winLine() {
        return Win.winLine(board, current.getFigure());
    }

    public char[][] boardCharArray() {
        return board.toCharArray();
    }

}
