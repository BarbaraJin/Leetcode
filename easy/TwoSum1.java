package easy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TwoSum1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
                if (numToIndexMap.containsKey(j)) {
                    answer[0] = numToIndexMap.get(j);
                    answer[1] = i;
                    break;
                }
                numToIndexMap.put(nums[i], i);
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        int[] a = new int[10000];
        int length = new Random().nextInt(10000);
        // int n = new Random().nextInt(length);
        // int m = new Random().nextInt(length);
        for (int i = 0; i < length; i++) {
            a[i] = new Random().nextInt(1000000000);
        }
        int[] test = { 0, 4, 3, 0 };
        int target = 0;
        Date start = new Date();
        // int[] answer = twoSum(a, n + m);
        int[] answer = twoSum(test, target);
        Date end = new Date();
        System.out.println("target: " + (target) + " " + printNode(test) + "\n " + printNode(answer));
        // System.out.println("target: " + (n + m) + printNode(a) + "\n " +
        // printNode(answer));
        System.out.println("run time: " + (end.getTime() - start.getTime()));
    }

    private static String printNode(int[] answer) {
        StringBuilder test = new StringBuilder();
        for (int i : answer) {
            test.append(i);
            test.append("->");
        }
        return test.toString();
    }
}
