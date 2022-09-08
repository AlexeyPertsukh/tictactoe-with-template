package com.company.controller;

import com.company.model.Board;
import com.company.model.Command;
import com.company.model.Figure;
import com.company.view.Printer;
import com.company.view.Reader;

public class Game {

    private static final String GAME_OVER = "Game over";

    private final Printer printer;
    private final Reader reader;
    private final Board board;
    private final Figure figure1;
    private final Figure figure2;
    private Figure current;

    public Game(Printer printer, Reader reader, Board board, Figure figure1, Figure figure2) {
        this.board = board;
        this.printer = printer;
        this.reader = reader;
        this.figure1 = figure1;
        this.figure2 = figure2;
        current = figure1;
    }


    private Figure other() {
        return current == figure1 ? figure2 : figure1;
    }


    public void go() {
        printer.print(board);

        while (true) {
            String message = String.format("Player %c, enter you move: ", current.getChar());
            printer.print(message);
            String input = reader.read();
            Command command = new Command(input);

            if (!command.isMove()) {
                printer.println("unknown command");
                continue;
            }

            if(!move(command)) {
                continue;
            }

            printer.print(board);

            if (isWin()) {
                String winMessage = String.format("%s: Winner is %c", GAME_OVER, current.getChar());
                printer.println(winMessage);
                break;
            }

            if(isDraw()) {
                printer.println(GAME_OVER + ": draw");
                break;
            }

            current = other();
        }
    }

    private boolean isWin() {
        return WinController.isWin(board, current);
    }

    private boolean isDraw() {
        return DrawController.isDraw(board);
    }

    private boolean move(Command command) {
        int num = command.toInt() - 1;
        try {
            board.insert(num, current);
            return true;
        } catch (IllegalArgumentException e) {
            printer.println(e.getMessage());
            return false;
        }
    }

}
