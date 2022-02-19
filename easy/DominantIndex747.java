package easy;

import java.util.*;

public class DominantIndex747 {
    public static int dominantIndex(int[] nums) {
        int ml = 0, sl = 0, mi=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > ml) {
                sl = ml;
                ml = nums[i];
                mi = i;
            } else if (nums[i] > sl) {
                sl = nums[i];
            }
        }
        return ml >= sl * 2 ? mi : -1;
    }

    public static void main(String[] args) throws Exception {
        int[] input = new int[] {3,6,1,0, 13,5};

        Date start = new Date();
        int answer = dominantIndex(input);
        Date end = new Date();
        System.out.println(answer);
        System.out.println("run time: " + (end.getTime() - start.getTime()));
    }
}
