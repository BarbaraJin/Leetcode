package medium;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LengthOfLongestSubstring3 {
    public static int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int lastNoRepeatInd = 0;
        char[] input = s.toCharArray();
        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            if (charMap.containsKey(c)) {
                answer = Math.max(answer, i - lastNoRepeatInd);
                lastNoRepeatInd = Math.max(lastNoRepeatInd, charMap.get(c)+1);
                charMap.remove(c);
            }
            charMap.put(c, i);
        }
        answer = Math.max(answer, input.length - lastNoRepeatInd);
        return answer;
    }

    public static void main(String[] args) throws Exception {
        // int length = new Random().nextInt(50000);
        // for (int i = 0; i < length; i++) {
        // a[i] = new Random().nextInt(1000000000);
        // }
        // int[] test = { 0, 4, 3, 0 };
        // int target = 0;
        Date start = new Date();
        // int[] answer = twoSum(a, n + m);
        int answer = lengthOfLongestSubstring("abb");
        Date end = new Date();
        System.out.println("answer: " + answer);
        // System.out.println("target: " + (n + m) + printNode(a) + "\n " +
        // printNode(answer));
        System.out.println("run time: " + (end.getTime() - start.getTime()));
    }
}
