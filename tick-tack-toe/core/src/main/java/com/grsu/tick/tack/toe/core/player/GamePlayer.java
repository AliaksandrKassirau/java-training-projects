package com.grsu.tick.tack.toe.core.player;


import com.grsu.tick.tack.toe.core.PlayersMove;
import com.grsu.tick.tack.toe.core.field.Field;
import com.grsu.tick.tack.toe.core.field.Figure;

public interface GamePlayer {

    PlayersMove makeMove(Figure[][] field) throws NoPlayersMoveException;
}
