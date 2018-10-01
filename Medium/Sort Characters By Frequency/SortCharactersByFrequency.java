import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/* Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters. */

class SortCharactersByFrequency {
// class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> charFreqMap = new HashMap<Character, Integer>();
        char[] sToCharArray = s.toCharArray();
        for (char eachChar : sToCharArray) {
            charFreqMap.put(eachChar, charFreqMap.getOrDefault(eachChar, 0)+1);
        }

        ArrayList<Character>[] freqList = new ArrayList[s.length()];
        for (Character charKey : charFreqMap.keySet()) {
            int freq = charFreqMap.get(charKey)-1;
            if(freqList[freq] == null){
                freqList[freq] = new ArrayList<Character>();
            }
            freqList[freq].add(charKey);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            if(freqList[i]!=null){
                for (Character eachChar : freqList[i]) {
                    for(int freq = i+1;freq>0;freq--){
                        stringBuilder.append(eachChar.toString());
                    }
                }
                
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency test = new SortCharactersByFrequency();
        System.out.println(test.frequencySort(""));
    }
}