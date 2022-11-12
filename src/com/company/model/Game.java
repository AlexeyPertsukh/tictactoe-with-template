package com.company.model;

import com.company.model.board.Board;
import com.company.model.player.Player;
import com.company.model.rules.RulesWithBoard;

public class Game {

    protected final Board board = new Board(Figure.NULL);
    protected final Player player1;
    protected final Player player2;
    protected Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
    }

    public void changeCurrent() {
        currentPlayer = otherPlayer();
    }

    private Player otherPlayer() {
        return currentPlayer == player1 ? player2 : player1;
    }

    public void move(int num) {
        board.insert(num, currentPlayer.getFigure());
    }

    public String getCurrentPlayerName() {
        return currentPlayer.getName();
    }

    public Board getBoard() {
        return board;
    }

    public boolean isWin() {
        RulesWithBoard rules = new RulesWithBoard();
        return rules.isWin(board, currentPlayer.getFigure());
    }

    public int winLine() {
        RulesWithBoard rules = new RulesWithBoard();
        return rules.winLine(board, currentPlayer.getFigure());
    }

    public boolean isDraw() {
        RulesWithBoard rules = new RulesWithBoard();
        return rules.isDraw(board);
    }

    public char[][] boardChars() {
        return board.toCharArray();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Moves getMoves() {
        int freeMoves = board.bitesOf(Figure.NULL);
        int currentMoves = board.bitesOf(currentPlayer.getFigure());
        int otherMoves = board.bitesOf(otherPlayer().getFigure());

        return new Moves(freeMoves, currentMoves, otherMoves);
    }


}
