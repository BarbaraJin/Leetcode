package easy;

import java.util.*;

public class CountingBits338 {
    public static int[] countBits(int n) {
        int m = n + 1;
        int[] a = new int[m];
        a[0] = 0;
        if (n == 0) {
            return a;
        }
        a[1] = 1;
        if (n == 1) {
            return a;
        }
        for (int i = 1;; i++) {
            int j = i << 1;
            if (j < m) {
                a[j] = a[i];
            } else {
                return a;
            }
            j = (i << 1) | 1;
            if (j < m) {
                a[j] = a[i] + 1;
            } else {
                return a;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int h = 8;
        Long start = System.nanoTime();
        int[] ans = countBits(h);
        Long end = System.nanoTime();
        System.out.println(printAnswer(ans));
        System.out.println("run time: " + (end - start));
    }

    private static String printAnswer(int[] answer) {
        StringJoiner print = new StringJoiner("");
        for (int a : answer) {
            print.add(String.valueOf(a));
        }
        return print.toString();
    }
}
