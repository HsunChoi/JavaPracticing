package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 11/17/15.
 *
 *
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
 */
public class GasStation {
    public static void main(String[]args){
        int[] gas = {2, 3, 9, 1, 7, 5, 3, 6, 7, 3, 4, 5};
        int[] cost = {4, 5, 5, 1, 7, 3, 4, 7, 8, 2, 3, 5};
        System.out.println(canCompleteCircuit(gas, cost));
        System.out.println(canCompleteCircuit1(gas, cost));

    }

    /**
     * First, let us see a method which has a high time complexity
     * Low performance, directly solution
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas;
        int sumCost;
        outloop: for(int i = 0; i < gas.length; i++){
            sumGas = gas[i];
            sumCost = cost[i];
            for(int j = i + 1; j < gas.length; j++){
                if(sumGas < sumCost){
                    continue outloop;
                }
                sumGas += gas[j];
                sumCost += cost[j];
            }
            for(int j = 0; j <= i; j++){
                if(sumGas < sumCost){
                    continue outloop;
                }
                sumGas += gas[j];
                sumCost += cost[j];
            }
            return i;
        }
        return -1;
    }

    public static int canCompleteCircuit1(int[] gas, int[] cost){
        int totalGas = 0;
        int tank = 0;
        int index = 0;
        for(int i = 0; i < gas.length; i++){
            int cur = gas[i] - cost[i];
            tank += cur;
            if(tank < 0){
                index = i + 1;
                tank = 0;
            }
            totalGas += cur;
        }
        return totalGas < 0 ? -1 : index;
    }

}






















