/*Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.*/

using namespace std;
#include<iostream>
#include <math.h>

class Solution {
public:
    bool isPalindrome(int x) {

    	if(x<0){
    		return false;
    	}
    	// count length
    	int length = 0;
    	int tempX = x;
        while(tempX > 0){
        	tempX = tempX/10;
        	length++;
        }

        // check palindrome
        int last=0;
        int first=0;
        while (last == first){
        	if (length < 2){
        		return true;
        	}
        	int multi = pow(10,length-1);
        	length = length-2;
        	last = x%10;
        	first = x/multi;
        	x = x/10;
        	x = x - first*(multi/10);
        }
        return false;
    }
};

int main(int argc, char const *argv[])
{
	Solution answer;
    bool ans = answer.isPalindrome(1001);
	if(ans){
		cout<<"true";
	}
    else{
        cout << "false";
    }
	return 0;
}