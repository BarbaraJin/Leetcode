package arrays.medium;

import java.util.*;

import print.Print;

public class ReverseWordsInAString151 {
    public static String reverseWords(String s) {
        StringBuilder sj = new StringBuilder();
        int l = s.length();
        int k = 0;
        for (int i = l - 1; i > -1; i--) {
            if (s.charAt(i) != ' ') {
                k++;
            } else if (k != 0) {
                if (sj.length() != 0) {
                    sj.append(" ");
                }
                sj.append(s.substring(i + 1, i + k + 1));
                k = 0;
            }
            if (i == 0 && k != 0) {
                if (sj.length() != 0) {
                    sj.append(" ");
                }
                sj.append(s.substring(0, k));
            }
        }
        return sj.toString();
    }

    public static void main(String[] args) throws Exception {
        String s = "    hello world  ";
        Date start = new Date();
        String answer = reverseWords(s);
        Date end = new Date();
        Print.print(answer);
        Print.printRunTime(start, end);
    }
}
