package com.grsu.tick.tack.toe.console;

import com.grsu.tick.tack.toe.core.PlayersMove;
import com.grsu.tick.tack.toe.core.field.Figure;
import com.grsu.tick.tack.toe.core.player.AbstractPlayer;
import com.grsu.tick.tack.toe.core.player.NoPlayersMoveException;

public class ConsolePlayer extends AbstractPlayer {

    @Override
    public String getPlayersId() {
        return null;
    }

    @Override
    public PlayersMove makeMove(Figure[][] field) throws NoPlayersMoveException {
        return null;
    }
}
