package com.xun.java.practing.careerup.MemoryStructureDesign.src;

/**
 * Created by cuixun on 4/30/15.
 */
public class MemoryStructureDesign {
    /**
     * set a data structure implement like a memory.
     * 1, if the memory is full, rewrite
     * the most previous data.
     * 2, When peek, peek the most recent data.
     * @param args
     */
    public static void main(String[]args){
        Memory m = new Memory();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int i = 0; i < a.length; i++){
            m.add(a[i]);
        }
        System.out.println(m.peek());
        for(int i = 0; i < 20; i ++){
            System.out.print(m.peek() + " ");
            m.pointer++;
        }
    }
}
