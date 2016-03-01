package com.xun.java.practing.app.GoGame;

import java.awt.*;

/**
 * Created by cuixun on 4/5/14.
 */
public class StartGame {
    public static void main(String[] args) {
        Frame f = new Frame("GoGame");
        f.setResizable(false);
        f.setLayout(new BorderLayout());
        GoGame goGame = new GoGame();
        goGame.init();
        goGame.start();
        f.setSize(goGame.getWidth(), 20 + goGame.getHeight());
        f.add(goGame, "Center");
        f.setVisible(true);
    }
}
