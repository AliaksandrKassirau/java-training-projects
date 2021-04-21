package com.grsu.tick.tack.toe.desktop.player;

import com.grsu.tick.tack.toe.core.PlayersMove;
import com.grsu.tick.tack.toe.core.field.Figure;
import com.grsu.tick.tack.toe.core.player.AbstractPlayer;
import com.grsu.tick.tack.toe.core.player.NoPlayersMoveException;

import java.util.Queue;

public class SwingPlayer extends AbstractPlayer {
    private String id;
    private final Queue<PlayersMove> movesQueue;

    public SwingPlayer(String id, Queue<PlayersMove> movesQueue) {
        this.id = id;
        this.movesQueue = movesQueue;
    }

    @Override
    public PlayersMove makeMove(Figure[][] field) throws NoPlayersMoveException {
        synchronized (movesQueue) {
            while (movesQueue.isEmpty()) {
                try {
                    movesQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            PlayersMove move = movesQueue.poll();
            return move;
        }
    }

    @Override
    public String getPlayersId() {
        return id;
    }
}
