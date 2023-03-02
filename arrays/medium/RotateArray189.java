package arrays.medium;

import java.util.Date;

import print.Print;

public class RotateArray189 {
    public static void rotate(int[] nums, int k) {
        if (k == 0 || nums.length <= 1) {
            return;
        }
        int rn = 0;
        for (int i = 0; i < k && rn < nums.length; i++) {
            int ni = i;
            int cur = nums[ni];
            for (;;) {
                ni = ni + k;
                ni = ni >= nums.length ? (ni % nums.length) : ni;
                int temp = nums[ni];
                nums[ni] = cur;
                cur = temp;
                rn++;
                if (ni == i) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int[] a = { -1, -100, 3, 99 };
        Date start = new Date();
        rotate(a, 9);
        Date end = new Date();
        Print.printArrayInteger(a);
        Print.printRunTime(start, end);
    }
}
