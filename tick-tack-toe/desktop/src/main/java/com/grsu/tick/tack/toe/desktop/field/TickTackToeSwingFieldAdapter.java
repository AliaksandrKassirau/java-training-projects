package com.grsu.tick.tack.toe.desktop.field;

import com.grsu.tick.tack.toe.core.field.AbstractField;
import com.grsu.tick.tack.toe.core.field.Figure;

import java.util.Optional;

public class TickTackToeSwingFieldAdapter extends AbstractField {
    private TickTackToeSwingField swingField;

    public TickTackToeSwingFieldAdapter(TickTackToeSwingField swingField) {
        super(swingField.getFieldSize());
        this.swingField = swingField;
    }

    @Override
    public void render() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++ ) {
                char sign = Optional.ofNullable(field[i][j])
                        .map(Figure::sign)
                        .orElse('_');
                swingField.cells[i][j].setText(Character.toString(sign));
            }
            System.out.println();
        }
    }
}
