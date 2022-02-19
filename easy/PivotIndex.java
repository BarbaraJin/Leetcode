package easy;

import java.util.Date;

public class PivotIndex {
    public static int pivotIndex(int[] nums) {
        int ans = -1, sum = 0;
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        int lm = sums[sums.length - 1];
        for (int i = 0; i < sums.length; i++) {
            int right = i == 0 ? 0 : sums[i - 1];
            int left = lm - nums[i] - right;
            if (right == left) {
                return i;
            }
        }
        return ans;
    }

    public static int pivotIndex2(int[] nums) {
        int sum = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int left = sum - nums[i] - right;
            if (right == left) {
                return i;
            }
            right += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        int[] input = new int[] { 1,7,3,6,5,6 };

        Date start = new Date();
        int answer = pivotIndex2(input);
        Date end = new Date();
        System.out.println(answer);
        System.out.println("run time: " + (end.getTime() - start.getTime()));
    }
}
