package com.company.view;

import com.company.model.Board;

public interface Printer {

    void print(Board board);
    void print(String string);
    void println(String string);
}
