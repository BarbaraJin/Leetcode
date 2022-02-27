package easy;

// import java.util.*;

public class LongestCommonPrefix14 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return a.toString();
                }
            }
            a.append(c);
        }
        return a.toString();
    }

    public static void main(String[] args) throws Exception {
        String[] ss = new String[3];
        ss[0] = "bbbbbbb";
        ss[1] = "bbbb";
        ss[2] = "bbb";
        Long start = System.nanoTime();
        String answer = longestCommonPrefix(ss);
        Long end = System.nanoTime();
        System.out.println(answer);
        System.out.println("run time: " + (end - start));
    }

    // private String printAnswer(int[] answer) {
    // StringJoiner print = new StringJoiner("");
    // for (int a : answer) {
    // print.add(String.valueOf(a));
    // }
    // return print.toString();
    // }
}
