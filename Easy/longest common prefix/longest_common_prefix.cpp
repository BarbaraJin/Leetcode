/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.*/
using namespace std;
#include<iostream>
#include <math.h>
#include <vector>
#include <cstring>

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {

    	std::string answer = "";
    	if (strs.size()==0){
    		return answer;
    	}

    	string first = strs[0];
        for (unsigned int i = 0; i < first.size(); ++i)
        {
        	char cur = first[i];
        	for (std::vector<string>::iterator j = strs.begin(); j != strs.end(); j++)
        	{
        		string temp = *j;
        		if(cur != temp[i]){
        			return answer;
        		}
        	}
        	answer += cur;
        }
        return answer;
    }
};

int main(int argc, char const *argv[])
{
	vector<string> v = std::vector<string>();
	v.push_back("flow");
	v.push_back("fla");
	v.push_back("flb");

	Solution answer;
	string ans = answer.longestCommonPrefix(v);
	cout<< ans <<'\n';
	return 0;
}