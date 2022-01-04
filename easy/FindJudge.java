package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class FindJudge {

    public static int findJudge(int n, int[][] trust) {
        // if(n==1){
        //     return trust.length == 0? 1:-1;
        // }
        if(trust.length<n-1){
            return -1;
        }
        int[] trustedList = new int[n+1];
        int[] trustList = new int[n+1];
        for (int i = 0; i < trust.length; i++) {
            trustedList[trust[i][1]]++;
            trustList[trust[i][0]]++;
        }
        for (int i = 1; i < n+1; i++) {
            if(trustedList[i] == n-1 && trustList[i] == 0){
                return i;
            }
        }
        return -1;
    }

    // faster than 99.9% memory less than 74%
    public static int findJudge2(int n, int[][] trust) {
        // if(n==1){
        //     return trust.length == 0? 1:-1;
        // }
        if(n<1 || trust.length<n-1){
            return -1;
        }
        int[] trustedList = new int[n+1];
        for (int i = 0; i < trust.length; i++) {
            if(trustedList[trust[i][1]] != -1){
                trustedList[trust[i][1]]++;
            }
            trustedList[trust[i][0]] = -1;
        }
        for (int i=1; i<n+1; i++) {
            if(trustedList[i] == n-1){
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) throws Exception {
        int[][] town1 = { {1,2}};
        int[][] town2 = { {1,3}, {2,3}};
        int[][] town3 = { {1,3}, {2,3}, {3,1}};
        int[][] town4 = { };
        Date start = new Date();
        System.out.println("town1: " + findJudge2(2,town1));
        System.out.println("run time: " + (new Date().getTime() - start.getTime()));
        System.out.println("town2: " + findJudge2(3,town2));
        System.out.println("town3: " + findJudge2(3,town3));
        System.out.println("town4: " + findJudge2(1,town4));

        // int n = 1000;
        // int[][] town = new int[n][2];
        // Map<Integer, Integer> testMap = new HashMap<>();
        // Random test = new Random();
        // for (int i = 0; i < town.length; i++) {
        //     town[i][0] = new Random().nextInt(n);
        //     town[i][1] = new Random().nextInt(n);
        //     // System.out.println("time2: "+ i + " " + time2[i]);
        // }
        // Date start1 = new Date();
        // System.out.println("original: " + numPairsDivisibleBy60(town));
        // System.out.println("run time: " + (new Date().getTime() - start1.getTime()));
        // start1 = new Date();
        // System.out.println("new function: " + numPairsDivisibleBy60test1(town));
        // System.out.println("run time: " + (new Date().getTime() - start1.getTime()));
        // start1 = new Date();
        // System.out.println("new function3: " + numPairsDivisibleBy60test3(town));
        // System.out.println("run time: " + (new Date().getTime() - start1.getTime()));
    }
}
