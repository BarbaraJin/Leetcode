/* Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space? */

// class Solution {
class SortColors {
    public void sortColors1(int[] nums) {
        int zero=0,one=0,two=0;
        for (int num : nums) {
            if(num == 0){zero++;}
            else if(num == 1){one++;}
            else if(num == 2){two++;}
        }
        for (int i = 0; i < nums.length; ) {
            for(;zero>0;zero--){nums[i++]=0;}
            for(;one>0;one--){nums[i++]=1;}
            for(;two>0;two--){nums[i++]=2;}
        }

        // for (int num : nums) {
        //     System.out.print(num+" ");
        // }
    }


    public void sortColors2(int[] nums) {
        int zero=0,two=nums.length-1;
        for (int i = 0; i <= two;) {
            if(nums[i]==0){
                swap(nums, i, zero);
                zero++;
                i++;
            }
            else if(nums[i]==2){
                swap(nums, i, two);
                two--;
            }
            else{i++;}

        }
        // for (int num : nums) {
        //     System.out.print(num+" ");
        // }
    }

    private void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


    public static void main(String[] args) {
        int[] testArray = new int[]{1,2,0};
        SortColors test = new SortColors();
        test.sortColors1(testArray);
        test.sortColors2(testArray);
    }
}