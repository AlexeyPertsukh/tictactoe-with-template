package com.company.controller;

import com.company.model.Figure;
import com.company.model.Game;
import com.company.model.player.Player;
import com.company.view.ConsolePrinter;
import com.company.view.ConsoleReader;
import com.company.view.Printer;
import com.company.view.Reader;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player(Figure.X);
        Player player2 = new Player(Figure.ZERO);
        Game game = new Game(player1, player2);

        Printer printer = new ConsolePrinter();
        Reader reader = new ConsoleReader();
        GameController gameController = new GameController();
        gameController.go(game, printer, reader);
    }
}
