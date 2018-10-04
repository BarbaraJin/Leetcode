/* Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
Note:
The input array won't violate no-adjacent-flowers rule.
The input array size is in the range of [1, 20000].
n is a non-negative integer which won't exceed the input array size. */


class CanPlaceFlowers {
// class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int avaibleSlot = 0, answer = n;
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i]==1){
                answer -= countAvailableSlot(avaibleSlot-1);
                avaibleSlot = 0;
                i++;
            }
            else{
                avaibleSlot++;
            }
        }
        answer -= countAvailableSlot(avaibleSlot);
        if(answer<=0){
            return true;
        }
        return false;
    }

    public int countAvailableSlot(int slot) {
        int answer = 0;
        if(slot <= 0){
            return 0;
        }
        if(slot%2==0){
            answer = slot/2;
        }
        else{
            answer = (slot/2)+1;
        }
        return answer;
    }
}