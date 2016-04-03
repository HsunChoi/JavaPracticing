package com.xun.java.practing.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cuixun on 3/27/16.
 */
public class BurstBallons {

    public static void main(String[]args){
        int[] nums = {3,1,5,8, 0, 9, 6, 4, 1, 2, 3, 4, 1, 2, 5, 3};
        int[] nums1 = {3,1,5,8, 3, 3, 3, 3, 4, 4};
        System.out.print(maxCoins(nums1));



    }


    /**
     * coins[i][j] is max coins by bursing in [i,j) range (not including j).
     * The "ticks" in the picture is the trivial case which you can compute directly
     * because it contains only 1 balloon. We want to fill the table in the first row
     * eventually following the red arrow. For each cell on the 1st row, we go from the tick
     * to [0][j] following black arrow and [0][n] is our final answer. k is index of last balloon
     * bursted in [i,j), [i+1,j) is computed before [i,j), which makes the formula possible.
     * We should deal with i == 0 and j == n case specially.
     * @param nums
     * @return
     */
    public static int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] coins = new int[n + 1][n + 1]; // coins[i][j] is max coins by bursing in [i,j) range
        for (int j = 1; j <= n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                int max = 0;
                for (int k = i; k <= j - 1; k++) {// k is index of last balloon bursted in [i,j)
                    max = Math.max(max, coins[i][k] + coins[k + 1][j] + nums[k] * (j == n ? 1 : nums[j]) * (i == 0 ? 1 : nums[i - 1]));
                } // [i+1,j) is computed before [i,j), which makes above formula possible
                coins[i][j] = max;
            }
        }
        return coins[0][n];
    }

    public static int maxCoins1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        List<Integer> list = new LinkedList<>();
        list.add(1);
        for(int i : nums){
            list.add(i);
        }
        list.add(1);
        int[] res = new int[1];
        getMaxCoin(list, res, 0);
        return res[0];
    }

    static void getMaxCoin(List<Integer> list, int[] max, int curMax){
        if(list.size() <= 2){
            max[0] = Math.max(max[0], curMax);
            return;
        }
        int temp = curMax;

        for(int i = 1; i < list.size() - 1; i++){
            List<Integer> nList = new LinkedList<>(list);

            curMax += list.get(i - 1) * list.get(i) * list.get(i + 1);
            nList.remove(i);

            getMaxCoin(nList, max, curMax);

            curMax = temp;

        }

    }

}
