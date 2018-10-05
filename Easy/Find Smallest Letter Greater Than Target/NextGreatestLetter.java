/* Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter. */

// class Solution { 
class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int l=0,h=letters.length-1;
        while(l<=h){
            int current = l+ (h - l)/2;
            char currentChar = letters[current];
            if(currentChar>target){
                h = current-1;
            }
            else if (currentChar<=target){
                l = current+1;
                if(l==letters.length){
                    l--;
                    break;
                }
            }
        }
        char answer = (letters[l]>target)? letters[l]:letters[0];
        return answer;
    }

    public static void main(String[] args) {
    }
}