/*The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"*/

class Solution {
    public static String countAndSay(int n) {
        String answer;
        if(n==1){
            return "1";
        }
        else{
            answer = count(countAndSay(n-1));
        }
        return answer;
    }
    public static String count(String n){
    	StringBuilder sb = new StringBuilder();
        char[] nChar = n.toCharArray();
        char last = nChar[0];
        int count = 0;
        for(char each:nChar){
        	if(each == last){
        		count++;
        	}
        	else{
        		sb.append(count);
        		sb.append(last);
        		count = 1;
        	}
        	last = each;
        }
        sb.append(count);
        sb.append(last);
        return sb.toString();
    }

    public static void main(String[] args) {
    	String ans = countAndSay(10);
    	System.out.println(ans);
    }
}