/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For o is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.


Input: 'III'
Output: 3

Input: 'IV'
Output: 4

Input: 'IX'
Output: 9

Input: 'LVIII'
Output: 58
Explanation: C = 100, L = 50, XXX = 30 and III = 3.

Input: 'MCMXCIV'
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.*/
using namespace std;
#include<iostream>
#include <math.h>
#include <map>

class Solution {
public:
    int romanToInt(string s) {

    	int answer = 0;

        std::map<char, int> map;

        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;

        for (unsigned int i = 0; i < s.length(); i++)
        {
            char c = s[i];
            int cur = map.at(c);
            int next = 0;
            if(i+1 < s.length()){
                next = map.at(s[i+1]);
            }
            if(cur<next){
                cur = next-cur;
                i++;
            }
            answer += cur;
            
        }

        return answer;
    }
};

int main(int argc, char const *argv[])
{
	Solution answer;
	int asn = answer.romanToInt("MCMXCIV");
    cout<< asn << '\n';
	return asn;
}