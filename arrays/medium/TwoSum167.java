package arrays.medium;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import print.Print;

public class TwoSum167 {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> jToIMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (jToIMap.containsKey(numbers[i])) {
                return new int[] { jToIMap.get(numbers[i]), i + 1 };
            }
            jToIMap.put(target - numbers[i], i + 1);
        }

        return new int[] {};
    }

    public static void main(String[] args) throws Exception {
        int[] a = { -1001,-100,0,100};
        Date start = new Date();
        int[] answer = twoSum(a, -1101);
        Date end = new Date();
        Print.printArrayInteger(answer);
        Print.printRunTime(start, end);
    }
}
