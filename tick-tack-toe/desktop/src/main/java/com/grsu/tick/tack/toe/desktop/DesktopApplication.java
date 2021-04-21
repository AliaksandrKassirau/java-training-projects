package com.grsu.tick.tack.toe.desktop;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class DesktopApplication {

    public DesktopApplication() {

    }

    public static void main(String[] args) {
        Map<String, JFrame> frames = new HashMap<>();

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new GameFrame();
        });
    }
}
