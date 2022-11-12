package com.company.view;

public interface View {
    void showBoard(char[][] chars, int winLine);
    void showBoard(char[][] chars);
    void showWin(String playerName);
    void showDraw();
    void showPromptEnterMove(String playerName);
    void showErrorMessage(String errorMessage);
    String read();

}
