package com.xun.java.practing.careerup.SearchRoastedArray.src;

/**
 * Created by cuixun on 4/22/15.
 */
public class SearchRoastedArray {
    public static void main(String[]args){

    }

    public static Integer searchRoastedArray(int[] array, int target){
        if(array == null){
            return null;
        }
        if(array.length == 0){
            return null;
        }
        return searchRoastedArray(array, target, 0, array.length - 1);
    }

    /**
     *
     * @param array
     * @param target
     * @param left
     * @param right
     * @return
     */
    static Integer searchRoastedArray(int[]array, int target, int left, int right){
        int mid = (left + right) / 2;
        if(array[mid] == target){
            return mid;
        }
        if(right < left){
            return -1;
        }
        if(array[mid] < array[right]){    // the right in the normal order search the right first
            if(array[mid] <= target && target <= array[right]) {
                return searchRoastedArray(array, target, mid + 1, right);
            }else{
                return searchRoastedArray(array, target, left, mid - 1); // search the left part
            }
        }else if(array[mid] > array[right]){     //the left in the normal order
            if(array[left] <= target && target <= array[mid]) {
                return searchRoastedArray(array, target, left, mid - 1);
            }else{
                return searchRoastedArray(array, target, mid + 1, right);
            }
        }else if(array[mid] == array[left]){
            if(array[mid] != array[right]){
                return searchRoastedArray(array, target, mid + 1, right); //search right
            }else{
                int result = searchRoastedArray(array, target, left, mid - 1);
                if(result == -1){
                    return searchRoastedArray(array, target, mid + 1, right);
                }else{
                    return result;
                }

            }
        }

        return -1;
    }
}
