package com.xun.java.practing.careerup.HanoiSolution.src;

import java.util.Stack;

/**
 * Created by cuixun on 4/2/15.
 */
public class Tower {
    int index;
    Stack<Integer> stack;

    public Tower(){

    }

    public Tower(int index){
        this.index = index;
        stack = new Stack<Integer>();
    }

    public int getIndex(){
        return index;
    }

    public void add(int i){
        if(stack.isEmpty()){
            stack.push(i);
        }else if(i < stack.peek()){
            stack.push(i);
        }else{
            throw new IllegalArgumentException("number on the top must smaller than the downstairs' ");
        }
    }

    public void moveToTop(Tower buffer){
        int x = this.stack.pop();
        buffer.add(x);
        System.out.println("Move disk from " + getIndex() + " to " + buffer.getIndex());
    }

    public void moveDisks(int n, Tower destination, Tower buffer){
        if(n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveToTop(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }

}
