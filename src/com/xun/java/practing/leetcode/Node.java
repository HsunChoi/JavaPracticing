package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 3/23/15.
 */
public class Node {
    Node left;
    Node right;
    //Node prev;
    int data;
    public Node(){

    }
    public Node(int data){
        this.data = data;
    }
    public void setData(int data){
        this.data = data;
    }
    public int getData(){
        return this.data;
    }



}
