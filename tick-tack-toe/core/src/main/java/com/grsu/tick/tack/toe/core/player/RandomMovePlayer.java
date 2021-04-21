package com.grsu.tick.tack.toe.core.player;


import com.grsu.tick.tack.toe.core.PlayersMove;
import com.grsu.tick.tack.toe.core.field.Figure;

import java.util.Random;

public class RandomMovePlayer extends AbstractPlayer {
    private Random random = new Random();
    private String session;

    public RandomMovePlayer(String session) {
        this.session = session;
    }

    @Override
    public String getPlayersId() {
        return session;
    }

    @Override
    public PlayersMove makeMove(Figure[][] field) {
        return new PlayersMove(random.nextInt(3), random.nextInt(3));
    }
}
