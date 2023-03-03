package arrays.easy;

import java.util.Date;

import print.Print;

public class MaxConsecutiveOnes485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int a = 0, i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 1) {
                i++;
            } else {
                a = Math.max(a, i);
                i = 0;
            }
        }
        return Math.max(a, i);
    }

    public static void main(String[] args) throws Exception {
        int[] a1 = { 0 };
        int[] a2 = { 1, 1, 1, 1, 1, 1 };
        int[] a3 = { 1 };
        int[] a4 = { 1,1,0,1,1,1};
        int[] a5 = { 1,0,1,1,0,1};

        int[] a = a5;
        Date start = new Date();
        int answer = findMaxConsecutiveOnes(a);
        Date end = new Date();
        Print.print(answer);
        Print.printArrayInteger(a);
        Print.printRunTime(start, end);
    }
}
