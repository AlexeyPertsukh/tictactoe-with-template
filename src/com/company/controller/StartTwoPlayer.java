package com.company.controller;

import com.company.model.Figure;
import com.company.model.Game;
import com.company.model.player.Player;
import com.company.view.*;

public class StartTwoPlayer {

    public static void main(String[] args) {
        Player player1 = new Player(Figure.X);
        Player player2 = new Player(Figure.ZERO);
        Game game = new Game(player1, player2);
        View view = new ViewConsole(new ConsolePrinter(), new ConsoleReader());

        GameController gameController = new GameController(game, view);
        gameController.go();
    }
}
