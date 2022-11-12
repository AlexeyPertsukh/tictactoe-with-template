package com.company.model;

public class Moves {
    public final int free;
    public final int my;
    public final int other;

    public Moves(int free, int my, int enemy) {
        this.free = free;
        this.my = my;
        this.other = enemy;
    }
}
