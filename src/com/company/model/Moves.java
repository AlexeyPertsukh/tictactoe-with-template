package com.company.model;

public class Moves {
    public final int free;
    public final int current;
    public final int other;

    public Moves(int free, int my, int enemy) {
        this.free = free;
        this.current = my;
        this.other = enemy;
    }
}
