/*Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2*/

class Solution {
    public static int mySqrt(int x) {
        if(x==1||x==0){
            return x;
        }
        int answer;
        int min = 0;
        int max = x;

        while(true){
        	answer = min+(max-min)/2;
        	// System.out.println("answer "+answer);
        	int check = x/answer;
        	// System.out.println("check "+check);
        	if(check<answer){
        		max = answer;
        		// System.out.println("max "+max);
        	}
        	else{
        		if((answer+1)>(x/(answer+1))){
        			break;
        		}
        		else{
        			min = answer;
        			// System.out.println("min "+min);
        		}
        	}
        }
        return answer;
    }

    public static void main(String[] args) {
    	int ans = mySqrt(8);
    	System.out.println(ans);
    }
}