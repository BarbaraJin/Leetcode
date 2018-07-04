/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5*/

class Solution {
    public int lengthOfLastWord(String s) {
        char[] nChar = s.toCharArray();
        int last = 0;
        int count = 0;
        for(char each:nChar){
        	if(each != ' '){
        		count++;
        		last++;
        		if(count == 1){
        			last=1;
        		}
        	}
        	else{
        		count = 0;
        	}
        }
        return last;
    }
}