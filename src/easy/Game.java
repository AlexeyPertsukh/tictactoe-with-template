package easy;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private static final int SIDE = 3;
    private static final char EMPTY = ' ';
    private static final char FIRST_ADDRESS_CHAR = 'a';
    private static final char[] FIGURES = new char[]{'X', '0'};

    private final char[] board = new char[SIDE * SIDE];

    public Game() {
        Arrays.fill(board, EMPTY);
    }

    public void go() {
        Scanner sc = new Scanner(System.in);
        printBoard();
        char currentFigure = FIGURES[0];

        while (true) {

            System.out.printf("%c, your move: ", currentFigure);
            String input = sc.next().toLowerCase();
            char addressChar = input.charAt(0);
            if (input.length() != 1 || (addressChar < FIRST_ADDRESS_CHAR || addressChar > FIRST_ADDRESS_CHAR + SIDE * SIDE - 1)) {
                continue;
            }

            boolean updateResult = boardUpdate(addressChar, currentFigure);
            if (!updateResult) {
                continue;
            }

            printBoard();

            int binaryFigureMoves = getBinaryMoves(currentFigure);
            if (EasyRules.isWin(binaryFigureMoves)) {
                System.out.printf("GAME OVER: Winner is %c", currentFigure);
                break;
            }

            int binaryFreeMoves = getBinaryMoves(EMPTY);
            if (EasyRules.isDraw(binaryFreeMoves)) {
                System.out.println("GAME OVER: draw");
                break;
            }

               currentFigure = currentFigure == FIGURES[0] ? FIGURES[1] : FIGURES[0];
        }
    }

    private boolean boardUpdate(char addressChar, char figure) {
        int index = addressChar - FIRST_ADDRESS_CHAR;
        if (board[index] != EMPTY) {
            return false;
        }
        board[index] = figure;
        return true;
    }

    private int getBinaryMoves(char figure) {
        int binMoves = 0;
        int mask = 1;
        for (char c : board) {
            if (c == figure) {
                binMoves = binMoves | mask;
            }
            mask = mask << 1;
        }
        return binMoves;
    }

    public void printBoard() {
        final String formatFigure = " %c ";
        final String formatAddress = ".%c.";
        int mask = 1;
        char addressChar = FIRST_ADDRESS_CHAR;
        System.out.println();
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                char ch = board[i * SIDE + j] == EMPTY ? addressChar : board[i * SIDE + j];
                String format = board[i * SIDE + j] == EMPTY ? formatAddress : formatFigure;
                addressChar++;
                mask = mask << 1;
                System.out.printf(format, ch);

                if (j < SIDE - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < SIDE - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }


}
