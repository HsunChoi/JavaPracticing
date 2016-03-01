package com.xun.java.practing.app.GoGame;

/**
 * Created by cuixun on 4/4/14.
 */
public class Stone {
    public static int _black = 0, _white = 1;
    protected int x, y;
    protected int color;

    public Stone(int i, int j, int c) {
        x = i;
        y = j;
        color = c;
    }

    public String toString() {
        String c = (color == _black ? "black" : "white");
        return "[" + x + "," + y + "]:" + c;
    }
}
