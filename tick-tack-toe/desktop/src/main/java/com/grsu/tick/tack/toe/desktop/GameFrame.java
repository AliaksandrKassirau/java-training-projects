package com.grsu.tick.tack.toe.desktop;

import com.grsu.tick.tack.toe.core.Game;
import com.grsu.tick.tack.toe.core.PlayersMove;
import com.grsu.tick.tack.toe.core.player.RandomMovePlayer;
import com.grsu.tick.tack.toe.desktop.field.TickTackToeSwingField;
import com.grsu.tick.tack.toe.desktop.field.TickTackToeSwingFieldAdapter;
import com.grsu.tick.tack.toe.desktop.player.SwingPlayer;

import javax.swing.*;
import java.awt.*;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameFrame extends JFrame {

    public GameFrame() {
        setLayout(new BorderLayout());

        JTextField statusBar = new JTextField("Player1's Turn");
        statusBar.setEditable(false);
        add(statusBar, BorderLayout.SOUTH);

        Queue<PlayersMove> movesQueue = new LinkedBlockingQueue<>();

        TickTackToeSwingField field = new TickTackToeSwingField(3, movesQueue);
        field.setSize(300, 300);
        add(field, BorderLayout.CENTER);

        TickTackToeSwingFieldAdapter fieldAdapter = new TickTackToeSwingFieldAdapter(field);


        /*Game game = new Game(fieldAdapter)
                .joinGameAsPlayer(new RandomMovePlayer("1"))
                .joinGameAsPlayer(new RandomMovePlayer("2"));*/
/*        Game game = new Game(fieldAdapter)
                .joinGameAsPlayer(new SwingPlayer("1", movesQueue))
                .joinGameAsPlayer(new SwingPlayer("2", movesQueue));*/
        Game game = new Game(fieldAdapter)
                .joinGameAsPlayer(new SwingPlayer("1", movesQueue))
                .joinGameAsPlayer(new RandomMovePlayer("2"));

        new Thread(() -> {
            try {
                game.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}).start();

        this.setSize(new Dimension(800, 650));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        //setBounds(400, 400, 300, 300);
    }
}
