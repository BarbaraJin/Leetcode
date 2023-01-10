package arrays.easy;

import java.util.Date;

import print.Print;

public class RemoveDuplicates26 {
    public static int removeDuplicates(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j]!=nums[j-1]){
                nums[i++]=nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        int[] a = {1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,3};
        Date start = new Date();
        int answer = removeDuplicates(a);
        Date end = new Date();
        System.out.println(answer);
        Print.printArrayInteger(a);
        System.out.println("run time: " + (end.getTime() - start.getTime()));
    }
}
