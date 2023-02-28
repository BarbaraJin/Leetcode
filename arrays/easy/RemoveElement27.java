package arrays.easy;

import java.util.Date;

import print.Print;

public class RemoveElement27 {
    public static int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        int[] a1 = { -1001, -100, 0, 100 };
        int[] a2 = { 0,1,2,2,3,0,4,2 };
        int[] a3 = { 0 };
        int[] a = { 0,1,2,2,3,0,4,2 };
        Date start = new Date();
        int answer = removeElement(a, 6);
        Date end = new Date();
        Print.printInteger(answer);
        Print.printArrayInteger(a);
        Print.printRunTime(start, end);
    }
}
