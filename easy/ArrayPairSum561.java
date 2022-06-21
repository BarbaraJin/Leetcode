package easy;

import java.util.Arrays;

public class ArrayPairSum561 {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum +=nums[i];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        Long start = System.nanoTime();
        int answer = arrayPairSum(new int[] {2,-10});
        Long end = System.nanoTime();
        System.out.println("answer: " + answer);
        System.out.println("run time: " + (end - start));
    }
}
