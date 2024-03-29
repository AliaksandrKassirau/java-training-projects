package com.grsu.tick.tack.toe.core.field;

public enum Figure {
    TIC_TAC('X'),
    TOE('0');

    private char sign;

    Figure(char sign) {
        this.sign = sign;
    }

    public char sign() {
        return sign;
    }

}