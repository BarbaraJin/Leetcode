import java.util.Arrays;
import java.util.List;

/* Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function. */

class NumArray {

    List<Integer> list = new ArrayList<Integer>();

    public NumArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = (i==0)? nums[0]:list.get(i-1)+nums[i];
            list.add(num);
        }
    }
    
    public int sumRange(int i, int j) {
        if(list.isEmpty()){
            return 0;
        }
        int toJ = list.get(j);
        int toI = (i==0)? 0:list.get(i-1);
        return toJ-toI;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */