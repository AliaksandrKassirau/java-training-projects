package com.grsu.tick.tack.toe.console;

import com.grsu.tick.tack.toe.core.Game;
import com.grsu.tick.tack.toe.core.player.RandomMovePlayer;

public class ConsoleApplication {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(new ConsoleField(3))
                .joinGameAsPlayer(new RandomMovePlayer("1"))
                .joinGameAsPlayer(new RandomMovePlayer("2"));
        game.start();
    }
}
