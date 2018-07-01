/*Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21
*/
import java.util.Stack;

class Solution {
    public int reverse(int x) {
    	int answer = 0;
        boolean neg = false;
        if(x<0){
            neg = true;
        }
        Stack<Character> stack = new Stack<>();
        String input = ""+x;
        for(char each:input.toCharArray()){
            stack.push(each);
        }
        int countLength = input.length();
        if(neg){countLength--;}
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<countLength; i++){
            builder.append(stack.pop());
        }
        String answerString = builder.toString();
        try{
            answer = Integer.parseInt(answerString);
            if(neg){
                answer = answer*-1;
            }
        }
        catch(Exception e){
            answer = 0;
        }
        return answer;
    }

}