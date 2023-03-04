package arrays.easy;

import java.util.*;

import print.Print;

public class MoveZeroes283 {
    public static void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int c = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[c++] = n;
            }
        }
        for (; c < nums.length; c++) {
            nums[c] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        int[] a = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int[] a1 = { 0, 0 };
        int[] a3 = { 0, 1, 0, 3, 12 };
        int[] a4 = { -10, 1, 0, 3, 12 };
        int[] a5 = { 1 };
        Date start = new Date();
        moveZeroes(a);
        Date end = new Date();
        Print.printArrayInteger(a);
        Print.printRunTime(start, end);
    }
}
