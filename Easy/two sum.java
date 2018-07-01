/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
        	map.put(nums[i], i); //key=num,value=ind
        }
        for(int i=0; i<nums.length; i++){
        	int secondNum = target-nums[i];
        	if (map.containsKey(secondNum) && map.get(secondNum) != i){
        		answer[0]=i;
        		answer[1]=map.get(secondNum);
        	}

        }
        return answer;
    }
}