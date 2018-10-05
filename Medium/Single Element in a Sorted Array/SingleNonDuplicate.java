/* Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: [3,3,7,7,8,11,11]
Output: 10
Note: Your solution should run in O(log n) time and O(1) space. */

class SingleNonDuplicate {
// class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int answer=0;
        int l=0,h=nums.length-1,curind=l+(h-l)/2,cur=nums[curind];
        while(l<=h){
            curind=l+(h-l)/2;
            cur=nums[curind];
            if(l==h){
                answer = cur;
                break;
            }
            if(cur==nums[curind-1]){
                if(curind%2==0){
                    h=curind-1;
                }
                else{
                    l=curind+1;
                }
            }
            else if(curind==nums.length-1){
                answer = cur;
                break;
            }
            else if(cur==nums[curind+1]){
                if(curind%2!=0){
                    h=curind-1;
                }
                else{
                    l=curind+1;
                }
            }
            else{
                answer = cur;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] test = new int[]{0,1,1};
        SingleNonDuplicate testc = new SingleNonDuplicate();
        int answer = testc.singleNonDuplicate(test);
        System.out.print(answer);
    }
}