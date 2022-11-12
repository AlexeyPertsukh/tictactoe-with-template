package com.company.controller;

import com.company.model.*;
import com.company.model.exception.GameException;
import com.company.model.player.BotPlayer;
import com.company.view.View;

public class GameController {

    private static final String GAME_OVER = "Game over";
    private final Game game;
    private final View view;

    public GameController(Game game, View view) {
        this.game = game;
        this.view = view;
    }

    public void go() {
        view.showBoard(boardChars());

        while (true) {
            try{
                view.showPromptEnterMove(game.getCurrentPlayerName());

                int move = nextMove();

                makeMove(move);

                if (game.isWin()) {
                    view.showBoard(boardChars(), game.winLine());
                    view.showWin(game.getCurrentPlayerName());
                    break;
                }

                view.showBoard(boardChars());

                if (game.isDraw()) {
                    view.showDraw();
                    break;
                }

                game.changeCurrent();
            } catch (GameException e) {
                view.showErrorMessage(e.getMessage());
            }

        }
    }

    private void makeMove(int move) {
        int num = move - 1;
        game.move(num);
    }

    private int nextMove() {
        if (game.getCurrentPlayer() instanceof BotPlayer bot) {
            return bot.nextMove(game.getMoves());
        } else {
            String s = view.read();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new GameException("Illegal input");
            }
        }

    }

    private char[][] boardChars() {
        char[][] out = game.boardChars();
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[i].length; j++) {
                if(out[i][j] == game.getBoard().getEmptyFigure().getChar()) {
                    char numChar = (char)('1' + i * out.length + j);
                    out[i][j] = numChar;
                }
            }
        }
        return out;
    }



}
