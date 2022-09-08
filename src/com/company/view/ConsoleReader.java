package com.company.view;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    @Override
    public String read() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
