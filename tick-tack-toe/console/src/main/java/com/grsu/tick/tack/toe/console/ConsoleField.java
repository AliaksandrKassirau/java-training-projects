package com.grsu.tick.tack.toe.console;

import com.grsu.tick.tack.toe.core.field.AbstractField;
import com.grsu.tick.tack.toe.core.field.Figure;

import java.util.Optional;

public class ConsoleField extends AbstractField {
    public ConsoleField(int fieldSize) {
        super(fieldSize);
    }

    @Override
    public void render() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++ ) {
                char sign = Optional.ofNullable(field[i][j])
                        .map(Figure::sign)
                        .orElse('_');
                System.out.print(sign + " ");
            }
            System.out.println();
        }
    }
}
