package com.company.controller;

import com.company.model.*;
import com.company.model.ai.AiRandomMove;
import com.company.model.player.BotPlayer;
import com.company.model.player.Player;
import com.company.view.*;

public class StartWithBot {
    public static void main(String[] args) {
        Player player1 = new Player(Figure.X);
        Player player2 = new BotPlayer(Figure.ZERO, new AiRandomMove());
        Game game = new Game(player1, player2);
        View view = new ViewConsole(new ConsolePrinter(), new ConsoleReader());

        GameController gameController = new GameController(game, view);
        gameController.go();
    }
}
