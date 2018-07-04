/*Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "aab"
Output: -1*/

class Solution {
    public static int strStr(String haystack, String needle) {
    	int answer = -1;
    	if(needle.length()>haystack.length()){
    		return answer;
    	}
    	if(needle.length()==0){
    		return 0;
    	}
        int hInd=0, nInd=0;
        while (hInd<haystack.length()) {
        	// System.out.println("hInd "+hInd);
        	// System.out.println("nInd "+nInd);
        	if(haystack.charAt(hInd) == needle.charAt(nInd)){
        		nInd++;
        		if(nInd == needle.length()){
        			answer = hInd - needle.length()+1;
        			return answer;
        		}
        	}
        	else{
        		hInd = hInd-nInd;
        		nInd = 0;
        	}
        	hInd++;
        }
        return answer;
    }
    public static void main(String[] args) {
    	String s1 = "aaaaa";
    	String s2 = "aaab";
    	int ans = strStr(s1, s2);
    	char tem = s1.charAt(1);
    	System.out.println(ans);
    }
}