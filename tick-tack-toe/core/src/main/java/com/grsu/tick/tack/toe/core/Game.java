package com.grsu.tick.tack.toe.core;

import com.grsu.tick.tack.toe.core.events.FieldChangedEvent;
import com.grsu.tick.tack.toe.core.field.Field;
import com.grsu.tick.tack.toe.core.field.Figure;
import com.grsu.tick.tack.toe.core.player.GamePlayer;
import com.grsu.tick.tack.toe.core.player.NoPlayersMoveException;
import com.grsu.tick.tack.toe.core.player.Player;

import java.util.*;

public class Game {
    private static final long WAITING_PLAYERS_TIMEOUT = 20000L;
    private Status gameStatus = Status.CREATED;
    private final Field field;
    private final Stack<Figure> figuresStack;
    private final Map<String, Player> playersByIds = new HashMap<>();
    private final Map<Figure, Player> playersByFigures = new EnumMap<>(Figure.class);

    public Game(Field field) {
        this.field = field;

        this.figuresStack =  new Stack<>();
        this.figuresStack.push(Figure.TOE);
        this.figuresStack.push(Figure.TIC_TAC);
        //Collections.shuffle(this.figuresStack);
    }

    public synchronized Game joinGameAsPlayer(Player player) {
        if (!playersByIds.containsKey(player.getPlayersId()) && playersByIds.size() == 2) {
            throw new IllegalStateException("Exceeds limit of players in one game");
        }
        if (!playersByIds.containsKey(player.getPlayersId())) {
            playersByFigures.put(figuresStack.pop(), player);
        }
        playersByIds.put(player.getPlayersId(), player);

        if (playersByIds.size() == 2) {
            gameStatus = Status.READY;
            notify();
        }

        return this;
    }

    public Field getField() {
        return field;
    }

    public GameStats start() throws InterruptedException {
        if (gameStatus != Status.READY) {
            gameStatus = Status.WAITING_FOR_PLAYERS;
            synchronized(this) {
                wait(WAITING_PLAYERS_TIMEOUT);
            }
        }
        if (gameStatus != Status.READY) {
            throw new IllegalStateException("Game can't be started because no all players joined");
        }
        gameStatus = Status.IN_PROGRESS;
        initPlayers();

        notifyFieldChanged();

        do {
            for (Map.Entry<Figure, Player> entry : playersByFigures.entrySet()) {
                PlayersMove move = makeMove(entry.getValue());
                field.setMove(entry.getKey(), move);
                notifyFieldChanged();

                if (field.isGameFinished())
                    break;
            }
        } while (!field.isGameFinished());

        gameStatus = Status.FINISHED;

        return new GameStats();
    }

    private void initPlayers() {
    }

    private void notifyFieldChanged() {
        //setChanged();
        field.render();
        //notifyObservers(new FieldChangedEvent(field.getCopyOfTheField()));
    }

    private PlayersMove makeMove(GamePlayer player) {
        PlayersMove move = null;
        try {
            while (!field.isMoveValid(move)) {
                move = player.makeMove(field.getCopyOfTheField());
            }
        } catch (NoPlayersMoveException e) {
            throw new IllegalStateException("No player's move", e);
        }

        return move;
    }


    public enum Status {
        CREATED,
        WAITING_FOR_PLAYERS,
        READY,
        IN_PROGRESS,
        FINISHED
    }
}
