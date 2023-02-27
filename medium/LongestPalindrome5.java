package medium;

public class LongestPalindrome5 {
    public static String longestPalindrome(String s) {
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j + i <= s.length(); j++) {
                if (isPalindrome(s.substring(j, j + i))) {
                    return s.substring(j, j + i);
                }
            }
        }
        return "";
    }

    public static Boolean isPalindrome(String s) {
        int i, j;
        if (s.length() % 2 == 0) {
            i = s.length() / 2 - 1;
            j = s.length() / 2;
        } else {
            i = s.length() / 2 - 1;
            j = s.length() / 2 + 1;
        }
        for (; i > -1 && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Long start = System.nanoTime();
        String answer = longestPalindrome("cba");
        Long end = System.nanoTime();
        System.out.println("answer: " + answer);
        System.out.println("run time: " + (end - start));
    }
}
