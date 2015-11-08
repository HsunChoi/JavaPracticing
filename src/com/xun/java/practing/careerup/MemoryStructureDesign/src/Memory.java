package com.xun.java.practing.careerup.MemoryStructureDesign.src;

import java.util.LinkedList;

/**
 * Created by cuixun on 4/30/15.
 */
public class Memory extends LinkedList {
    int length = 10;
    int pointer = 0;

    Memory() {
        this.length = 10;
    }

    Memory(int length) {
        this.length = length;
    }

    @Override
    public boolean add(Object o) {
        if (pointer >= this.length) {
            pointer = pointer % this.length;

            super.set(pointer, o);
        } else {
            super.add(pointer, o);
        }
        pointer++;
        return true;
    }

    @Override
    public Object peek() {
        pointer = pointer % this.size();
        pointer--;
        if(pointer < 0 ){
            pointer = this.size() - 1;
        }
        return super.get(this.pointer++);

    }
}
