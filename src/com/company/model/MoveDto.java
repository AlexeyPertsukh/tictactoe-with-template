package com.company.model;

public class MoveDto {
    public final int free;
    public final int my;
    public final int other;

    public MoveDto(int free, int my, int enemy) {
        this.free = free;
        this.my = my;
        this.other = enemy;
    }
}
