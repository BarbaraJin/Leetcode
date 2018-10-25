
/* 
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6). */


// class Solution {
class NumDecodings {
    public int numDecodings(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int[] count = new int[s.length()+1];
        char[] sToCharArray = s.toCharArray();
        count[0]=1; 
        count[1]=(sToCharArray[0]=='0')? 0:1;
        

        for (int i = 1; i < s.length(); i++) {
            int cur = 0;
            if(sToCharArray[i]!='0'){
                cur=count[i];
            }
            int two = Integer.valueOf(String.copyValueOf(sToCharArray, i-1, 2));
            cur+=(two<=26&&two>=10)? count[i-1]:0;
            count[i+1]=cur;
        }
        int answer = (count[s.length()]<0)? 0:count[s.length()];
        return answer;
    }
    public static void main(String[] args) {
        NumDecodings numDecodingsI = new NumDecodings();
        System.out.println(numDecodingsI.numDecodings("10101"));
    }
}
