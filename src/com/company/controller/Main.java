package com.company.controller;

import com.company.model.Board;
import com.company.model.Figure;
import com.company.view.ConsolePrinter;
import com.company.view.ConsoleReader;
import com.company.view.Printer;
import com.company.view.Reader;

public class Main {

    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        Reader reader = new ConsoleReader();
        Board board = new Board();

        Game game = new Game(printer, reader, board, Figure.X, Figure.ZERO);
        game.go();
    }
}
