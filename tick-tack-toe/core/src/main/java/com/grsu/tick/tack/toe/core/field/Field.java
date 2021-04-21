package com.grsu.tick.tack.toe.core.field;


import com.grsu.tick.tack.toe.core.PlayersMove;

public interface Field {

    void setMove(Figure figure, PlayersMove move);

    boolean isMoveValid(PlayersMove move);

    boolean isGameFinished();

    boolean isThereWinner();

    boolean isThereRoomForMove();

    Figure[][] getCopyOfTheField();

    void render();
}
