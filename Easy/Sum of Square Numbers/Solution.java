/* Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: 3
Output: False */

class Solution {
    public boolean judgeSquareSum(int c) {
        int i =0, j = (int)Math.sqrt(c);
        while(i<=j){
            if(Math.pow(i, 2)+Math.pow(j, 2)==c){
                return true;
            }
            else if(Math.pow(i, 2)+Math.pow(j, 2)>c){
                j--;
            }
            else if(Math.pow(i, 2)+Math.pow(j, 2)<c){
                i++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.judgeSquareSum(3));
    }
}