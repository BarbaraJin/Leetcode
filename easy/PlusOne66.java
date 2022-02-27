package easy;

import java.util.*;

public class PlusOne66 {
    public static int[] plusOne(int[] digits) {
        int f = 1;
        for (int i = digits.length - 1; i > -1 && f != 0; i--) {
            int num = digits[i] + f;
            digits[i] = num % 10;
            f = num / 10;
        }
        if (f != 0) {
            int[] answer = new int[digits.length + 1];
            answer[0] = f;
            return answer;
        }
        return digits;
    }

    public static int[] plusOne2(int[] digits) {
        int f = 1;
        for (int i = digits.length - 1; i > -1; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                f = 1;
            } else {
                digits[i] = digits[i] + f;
                f = 0;
                return digits;
            }
        }
        int[] answer = new int[digits.length + 1];
        answer[0] = f;
        return answer;
    }

    public static void main(String[] args) throws Exception {
        int[] c0 = new int[] { 1, 9, 9, 9, 9, 9, 9, 9, 9 };
        Date start = new Date();
        int[] answer = plusOne2(c0);
        Date end = new Date();
        System.out.println(printAnswer(answer));
        System.out.println("run time: " + (end.getTime() - start.getTime()));
    }

    private static String printAnswer(int[] answer) {
        StringJoiner print = new StringJoiner("");
        for (int a : answer) {
            print.add(String.valueOf(a));
        }
        return print.toString();
    }
}
