package arrays.easy;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import print.Print;

public class PascalsTriangleII119 {
    public static List<Integer> getRow(int rowIndex) {
        int r = rowIndex + 1;
        Integer[] a = new Integer[r];
        int last = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <= i; j++) {
                int num = 1;
                if (j != 0 && j != i) {
                    num = a[j] + last;
                    last = a[j];
                }
                a[j] = num;
            }
        }
        return Arrays.asList(a);
    }

    public static void main(String[] args) throws Exception {
        Date start = new Date();
        List<Integer> answer = getRow(3);
        Date end = new Date();
        Print.printListInteger(answer);
        Print.printRunTime(start, end);
    }
}
