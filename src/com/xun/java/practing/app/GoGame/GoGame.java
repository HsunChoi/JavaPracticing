package com.xun.java.practing.app.GoGame;

/**
 * Created by cuixun on 4/5/14.
 */

import java.applet.Applet;
import java.awt.*;

public class GoGame extends Applet {
    Board board;


    public void init() {
        board = new Board();
        setLayout(new BorderLayout());
        setSize(board.getSize());
        add(board, "Center");
    }

    public int getWidth() {
        return board.getWidth();
    }

    public int getHeight() {
        return board.getHeight();
    }


}
