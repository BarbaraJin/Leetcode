/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.


Input: "()"
Output: true

Input: "()[]{}"
Output: true

Input: "(]"
Output: false

Input: "([)]"
Output: false

Input: "{[]}"
Output: true
*/

import java.util.Stack;

class Solution {
    public static boolean isValid(String s) {

        boolean answer = false;

        Stack<Character> stack = new Stack<Character>();

        for (char currentChar : s.toCharArray()) {
            if (currentChar == '(' || currentChar == '[' || currentChar == '{'){
                stack.push(currentChar);
            }
            else{
                if(stack.size()==0){
                    return false;
                }
                if (currentChar == ')'){
                    if(stack.lastElement() != '('){
                        break;
                    }
                }
                else if(currentChar == ']'){
                    if(stack.lastElement() != '['){
                        break;
                    }

                }
                else if(currentChar == '}'){
                    if(stack.lastElement() != '{'){
                        break;
                    }
                }
                stack.pop();
            }
        }
        if(stack.size()==0){
            answer = true;
        }
        return answer;
    }

    public static void main(String[] args) {
        if(isValid("(])")){
            System.out.println("true");
        }
    }
}