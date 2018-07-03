/*Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.*/
using namespace std;
#include<iostream>
#include <math.h>
#include <vector>
#include <limits.h>

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
    	int answer = 0;
    	unsigned int size = nums.size();
    	if(size<=1){
    		return size;
    	}
    	int last = nums[0];
    	answer++;
        for (unsigned int i= 1; i<size;){
        	int cur = nums[i];
        	if(cur != last){
        		answer++;
        		i++;
        	}
        	else{
        		nums.erase(nums.begin()+(answer));
        		size--;
        	}
        	last = cur;
        }
        return answer;
    }
};

int main(int argc, char const *argv[])
{
	vector<int> v = std::vector<int>();
	v.push_back(1);
	v.push_back(1);
	v.push_back(2);
	v.push_back(3);
	v.push_back(4);
	v.push_back(4);
	v.push_back(5);
	v.push_back(5);
	v.push_back(5);


	Solution answer;
	int ans = answer.removeDuplicates(v);
	cout << ans << '\n';

	for (std::vector<int>::iterator i = v.begin(); i != v.end(); ++i)
	{
		cout<<*i<<", ";
	}
}