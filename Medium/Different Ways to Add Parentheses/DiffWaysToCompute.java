import java.util.ArrayList;
import java.util.List;

/* Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation: 
((2-1)-1) = 0 
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10 */

// class DiffWaysToCompute {
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> answer = new ArrayList<Integer>();
        boolean noSim = true;
        for (int i = 0; i < input.length(); i++) {
            char charAtI = input.charAt(i);
            if(charAtI=='*'||charAtI=='-'||charAtI=='+'){
                noSim = false;
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length()));

                for (int l : left) {
                    for (int r : right) {
                        if(charAtI=='*'){
                            answer.add(l*r);
                        }
                        else if(charAtI=='+'){
                            answer.add(l+r);
                        }
                        else if(charAtI=='-'){
                            answer.add(l-r);
                        }
                    }
                }
            }
        }
        if(noSim){
            int num = Integer.valueOf(input);
            answer.add(num);
        }
        return answer;
    }


    // public static void main(String[] args) {
    //     DiffWaysToCompute t = new DiffWaysToCompute();
    //     List<Integer> test = new ArrayList<Integer>();
    //     test = t.diffWaysToCompute("2+3");
    //     for(int each: test){
    //         System.out.print(each+" ");
    //     }
    // }
}