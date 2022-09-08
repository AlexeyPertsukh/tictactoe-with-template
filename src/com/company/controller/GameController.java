package com.company.controller;

import com.company.model.*;
import com.company.view.Printer;
import com.company.view.Reader;

public class GameController {

    private static final String GAME_OVER = "Game over";

    public void go(Game game, Printer printer, Reader reader) {
        printer.printBoard(game.boardCharArray());

        while (true) {
            String message = String.format("Player %c, enter you move: ", game.getCurrentChar());
            printer.print(message);
            String input = reader.read();
            Command command = new Command(input);

            boolean moveResult = move(command, game, printer);
            if(!moveResult) {
                continue;
            }

            printer.printBoard(game.boardCharArray());

            if (game.isWin()) {
                String winMessage = String.format("%s: Winner is %c", GAME_OVER, game.getCurrentChar());
                printer.println(winMessage);
                break;
            }

            if(game.isDraw()) {
                printer.println(GAME_OVER + ": draw");
                break;
            }

            game.changeCurrent();
        }
    }

    private boolean move(Command command, Game game, Printer printer) {

        if (!command.isMove()) {
            printer.println("illegal move command");
            return false;
        }

        int num = command.toInt() - 1;
        try {
            game.move(num);
            return true;
        } catch (IllegalArgumentException e) {
            printer.println(e.getMessage());
            return false;
        }
    }

}
