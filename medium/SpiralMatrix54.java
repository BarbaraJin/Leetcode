package medium;

import java.util.*;

public class SpiralMatrix54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int r = 1, h = 0, maxj = matrix[0].length - 1, maxi = matrix.length - 1, minj = 0, mini = 1;
        List<Integer> answer = new ArrayList<>();
        int mn = matrix[0].length * matrix.length;
        for (int i = 0, j = 0; answer.size() < mn;) {
            answer.add(matrix[i][j]);
            if (r == 1 && h == 0 && j >= maxj) {
                r--;
                h++;
                maxj--;
            } else if (r == 0 && h == 1 && i >= maxi) {
                r--;
                h--;
                maxi--;
            } else if (r == -1 && h == 0 && j <= minj) {
                r++;
                h--;
                minj++;
            } else if (r == 0 && h == -1 && i <= mini) {
                r++;
                h++;
                mini++;
            }
            i += h;
            j += r;
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        // int[][] mat = new int[3][4];
        // mat[0] = new int[] { 1, 2, 3, 4 };
        // mat[1] = new int[] { 5, 6, 7, 8 };
        // mat[2] = new int[] { 9, 10, 11, 12 };
        int[][] mat = new int[2][1];
        mat[0] = new int[] { 1 };
        mat[1] = new int[] { 2 };
        int[][] m2 = new int[3][4];
        m2[0] = new int[] { 1, 2, -3, 4 };
        m2[1] = new int[] { -5, 6, 7, 8 };
        m2[2] = new int[] { 9, 10, 11, -12 };
        Date start = new Date();
        List<Integer> answer = spiralOrder(m2);
        Date end = new Date();
        System.out.println(printAnswer(answer));
        System.out.println("run time: " + (end.getTime() - start.getTime()));
    }

    private static String printAnswer(List<Integer> answer) {
        StringJoiner print = new StringJoiner(",");
        for (int i : answer) {
            print.add(String.valueOf(i));
        }
        return print.toString();
    }
}
