import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output: 
"a"
Note:
All the strings in the input will only contain lower-case letters.
The size of the dictionary won't exceed 1,000.
The length of all the strings in the input won't exceed 1,000. */

class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String answer = "";
        int longest = 0;
        int firstOccur = Integer.MAX_VALUE;

        List list = new ArrayList<Character>();
        char[] charArray = s.toCharArray();
        Character[] scharArray = new Character[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            scharArray[i] = new Character(charArray[charArray.length-i-1]);
        }

        for (int i=0;i<d.size();i++) {
            String var = d.get(i);
            list = new ArrayList<Character>(Arrays.asList(scharArray));
            int count = 0;
            char[] varCharA = var.toCharArray();
            char[] reverse = new char[varCharA.length];
            for(int j=0; j<varCharA.length;j++){
                reverse[j]=varCharA[varCharA.length-1-j];
            }
            int occur = list.indexOf(reverse[0]);
            for (char var2 : reverse) {
                int ind = list.indexOf(var2);
                if(ind != -1){
                    count++;
                }
                else{
                    break;
                }
                list = list.subList(ind+1, list.size());
            }
            if(count==var.length()){
                if(count>longest){
                    firstOccur = occur;
                    longest = count;
                    answer = d.get(i);
                }
                else if(count == longest){
                    if(occur<firstOccur){
                        firstOccur = occur;
                        answer = d.get(i);
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        LongestWordInDictionaryThroughDeleting test = new LongestWordInDictionaryThroughDeleting();
        String target = "abca";
        List testlist = new ArrayList<String>(Arrays.asList("a","b","c"));
        String answer = test.findLongestWord(target,testlist);
        System.out.print(answer);
    }
}