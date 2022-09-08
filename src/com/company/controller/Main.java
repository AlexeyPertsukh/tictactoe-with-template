package com.company.controller;

import com.company.model.Figure;
import com.company.model.Game;
import com.company.view.ConsolePrinter;
import com.company.view.ConsoleReader;
import com.company.view.Printer;
import com.company.view.Reader;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(Figure.X, Figure.ZERO);

        Printer printer = new ConsolePrinter();
        Reader reader = new ConsoleReader();
        GameController gameController = new GameController();
        gameController.go(game, printer, reader);

    }
}
