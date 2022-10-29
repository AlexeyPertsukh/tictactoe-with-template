package com.company.model;

import com.company.model.player.Player;
import com.company.controller.rules.Draw;
import com.company.controller.rules.WinController;

public class Game {

    protected final Board board = new Board();
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

    // TODO move to game controller
    private Player otherPlayer() {
        return currentPlayer == player1 ? player2 : player1;
    }

    // TODO move to game controller
    public void move(int num) {
        board.insert(num, currentPlayer.getFigure());
    }

    public String getCurrentName() {
        return currentPlayer.getName();
    }

    // TODO move to game controller
    public boolean isWin() {
        return WinController.isWin(board, currentPlayer.getFigure());
    }

    // TODO move to game controller
    public int winLine() {
        return WinController.winLine(board, currentPlayer.getFigure());
    }

    // TODO move to game controller
    public boolean isDraw() {
        return Draw.isDraw(board);
    }

    // TODO getBoard()

    public char[][] boardCharArray() {
        return board.toCharArray();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public MoveDto getMoveDto() {
        int freeMoves = board.figureMovesInBits(Figure.NULL);
        int currentMoves = board.figureMovesInBits(currentPlayer.getFigure());
        int otherMoves = board.figureMovesInBits(otherPlayer().getFigure());

        return new MoveDto(freeMoves, currentMoves, otherMoves);
    }




}
