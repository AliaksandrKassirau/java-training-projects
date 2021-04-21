package com.grsu.tick.tack.toe.core;

public final class PlayersMove {
    private final int i;
    private final int j;

    public PlayersMove(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int i() {
        return i;
    }

    public int j() {
        return j;
    }
}
