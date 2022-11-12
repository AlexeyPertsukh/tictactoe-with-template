package com.company.view;

public class ViewConsole implements View{
    private final Printer printer;
    private final Reader reader;

    public ViewConsole(Printer printer, Reader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    @Override
    public void showBoard(char[][] chars) {
        showBoard(chars, 0);
    }

    @Override
    public void showWin(String playerName) {
        String winMessage = String.format("GAME OVER: Winner is %s", playerName);
        printer.println(winMessage);
    }

    @Override
    public void showBoard(char[][] chars, int winLine) {

        final String basicFormat = " %c ";
        final String winFormat = "<%c>";

        StringBuilder builder = new StringBuilder("\n");
        int mask = 1;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                char ch = chars[i][j];

                String format = (winLine & mask) == 0 ? basicFormat : winFormat;
                mask = mask << 1;

                builder.append(String.format(format, ch));

                if (j < chars.length - 1) {
                    builder.append("|");
                }
            }
            builder.append("\n");
            if (i < chars.length - 1) {
                builder.append("---+---+---\n");
            }
        }

        printer.println(builder.toString());
    }

    @Override
    public void showDraw() {
        printer.println("GAME OVER: draw");
    }

    @Override
    public void showPromptEnterMove(String playerName) {
        String message = String.format("Player %s, enter you move: ", playerName);
        printer.print(message);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        printer.println(errorMessage);
    }

    @Override
    public String read() {
        return reader.read();
    }

}
