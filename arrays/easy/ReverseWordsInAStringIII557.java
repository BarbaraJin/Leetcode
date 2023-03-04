package arrays.easy;

import java.util.*;

import print.Print;

public class ReverseWordsInAStringIII557 {

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean isSpace = s.charAt(i) == ' ';
            if (!isSpace) {
                k++;
            }
            if (isSpace || i == s.length() - 1) {
                int start = 0;
                if (sb.length() != 0) {
                    sb.append(' ');
                }
                if (isSpace) {
                    start = i - 1;
                } else {
                    start = i;
                }
                for (int j = start; j > start - k; j--) {
                    sb.append(s.charAt(j));
                }
                k = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String s1 = "hello world";
        String s2 = "Let's take LeetCode contest";
        String s3 = "God Ding";
        String s = "o";
        Date start = new Date();
        String answer = reverseWords(s);
        Date end = new Date();
        Print.print(answer);
        Print.printRunTime(start, end);
    }
}
