package com.grsu.tick.tack.toe.desktop.field;

import com.grsu.tick.tack.toe.core.PlayersMove;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TickTackToeCell extends JButton {

    public TickTackToeCell(TickTackToeSwingField parent, int positionX, int positionY) {
        this.setActionCommand("" + positionX + positionY);
        this.putClientProperty("INDEX", new int[]{positionX, positionY});
        this.putClientProperty("OWNER", null);
        this.setSize(50, 50);
        this.setText("_");
        this.addActionListener((changeEvent) -> {
            JButton source = (JButton) changeEvent.getSource();
            int[] indeces = (int[]) source.getClientProperty("INDEX");
            parent.pushMove(new PlayersMove(indeces[0], indeces[1]));
            System.out.println(indeces);
        });
    }
}
