package arrays.medium;

import java.util.Date;
import print.Print;

public class MinimumSizeSubarraySum209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            for (; sum >= target; ) {
                answer = Math.min(answer, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return answer == Integer.MAX_VALUE? 0: answer;
    }

    public static void main(String[] args) throws Exception {
        int[] a = { 1,2,1,1,1,1,1,50 };
        Date start = new Date();
        int answer = minSubArrayLen(90, a);
        Date end = new Date();
        Print.print(answer);
        Print.printRunTime(start, end);
    }
}
