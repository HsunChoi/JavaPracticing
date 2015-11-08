package com.xun.java.practing.careerup.HanoiSolution.src;

/**
 * Created by cuixun on 4/2/15.
 */
public class Hanoi {
    public static void main(String[] args) {
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++){
            towers[i] = new Tower(i);
        }
        int n = 3;
        for(int i = n; i > 0; i--){
            towers[0].add(i);
        }
        towers[0].moveDisks(n, towers[2], towers[1]);
    }
}
