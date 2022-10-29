package com.company.controller;

import com.company.model.*;
import com.company.model.Command;
import com.company.model.exception.GameException;
import com.company.model.player.BotPlayer;
import com.company.view.Printer;
import com.company.view.Reader;

public class GameController {

    private static final String GAME_OVER = "Game over";

    // TODO reader, printer to class GameView
    public void go(Game game, Printer printer, Reader reader) {
        printer.printBoard(game.boardCharArray());

        while (true) {
            String message = String.format("Player %s, enter you move: ", game.getCurrentName());
            printer.print(message);

            // TODO change to int getMove(), delete class Command
            Command command = inputCommand(game, reader);
            if(checkCurrentPlayerIsBot(game)) {
                printer.println(command.getValue());
            }

            if (!command.isMove()) {
                printer.println("illegal move command");
                continue;
            }

            boolean moveResult = move(command, game, printer);
            if(!moveResult) {
                continue;
            }

            if (game.isWin()) {
                printer.printBoard(game.boardCharArray(), game.winLine());
                String winMessage = String.format("%s: Winner is %s", GAME_OVER, game.getCurrentName());
                printer.println(winMessage);
                break;
            }

            printer.printBoard(game.boardCharArray());

            if(game.isDraw()) {
                printer.println(GAME_OVER + ": draw");
                break;
            }

            game.changeCurrent();
        }
    }

    // TODO remove Printer from move()
    private boolean move(Command command, Game game, Printer printer) {

        int num = command.getMove() - 1;
        try {
            game.move(num);
            return true;
        } catch (GameException e) {
            printer.println(e.getMessage());    // TODO тут не должен печатать
            return false;
        }
    }

    // TODO создать класс PlayerController который будет сам определять бот или человек и получать от него следующий ход
    private Command inputCommand(Game game, Reader reader) {
        String input;
        if(checkCurrentPlayerIsBot(game)) {
            BotPlayer botPlayer = (BotPlayer) game.getCurrentPlayer();
            MoveDto moveDto = game.getMoveDto();
            input = botPlayer.nextMove(moveDto);
        } else {
            input = reader.read();
        }

        return new Command(input);
    }

    private boolean checkCurrentPlayerIsBot(Game game) {
        return game.getCurrentPlayer() instanceof BotPlayer;
    }

}
