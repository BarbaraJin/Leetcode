package medium;

import java.util.*;

public class FindDiagonalOrder498 {
    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = m == 0 ? 0 : mat[0].length;
        int l = m * n;
        int[] answer = new int[l];
        int factorUp = 1; // up m-1,n+1; down m+1,n-1
        for (int i = 0, j = 0, a = 0; a < l;) {
            if (i < m && j < n) {
                answer[a++] = mat[i][j];
            }
            i = i + (-1 * factorUp);
            j = j + factorUp;
            if (i < 0 || j < 0) {
                i = i < 0 ? 0 : i;
                j = j < 0 ? 0 : j;
                factorUp *= -1;
            }
        }
        return answer;
    }

    public static int[] findDiagonalOrder2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int i = 0, j = 0, a = 0;
        while (i < m && j < n) {
            ans[a++] = mat[i][j];
            if ((i + j) % 2 == 0) { // moving up
                if (j == n - 1) {
                    i++;
                } else if (i == 0) {
                    j++;
                } else {
                    i--;
                    j++;
                }
            } else { // moving down
                if (i == m - 1) {
                    j++;
                } else if (j == 0) {
                    i++;
                } else {
                    i++;
                    j--;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        int[][] mat = new int[3][4];
        mat[0] = new int[] { 1, 2, 3, 4 };
        mat[1] = new int[] { 5, 6, 7, 8 };
        mat[2] = new int[] { 9, 10, 11, 12 };

        Date start = new Date();
        int[] answer = findDiagonalOrder2(mat);
        Date end = new Date();
        System.out.println(printAnswer(answer));
        System.out.println("run time: " + (end.getTime() - start.getTime()));
    }

    private static String printAnswer(int[] answer) {
        StringJoiner print = new StringJoiner(",");
        for (int i : answer) {
            print.add(String.valueOf(i));
        }
        return print.toString();
    }
}
