package com.grsu.tick.tack.toe.desktop.field;

import com.grsu.tick.tack.toe.core.PlayersMove;

import javax.swing.*;
import java.awt.*;
import java.util.Queue;

public class TickTackToeSwingField extends JPanel {
    private final Queue<PlayersMove> movesQueue;
    TickTackToeCell[][] cells;
    int size;

    public TickTackToeSwingField(int size, Queue<PlayersMove> movesQueue) {
        setLayout(new GridLayout(size,size));
        this.movesQueue = movesQueue;
        this.size = size;
        cells = new TickTackToeCell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                TickTackToeCell tickTackToeCell = new TickTackToeCell(this, i, j);
                cells[i][j] = tickTackToeCell;
                this.add(tickTackToeCell);
            }
        }
    }

    public int getFieldSize() {
        return size;
    }

    void pushMove(PlayersMove move) {
        synchronized (movesQueue) {
            movesQueue.add(move);
            movesQueue.notify();
        }
    }
}
