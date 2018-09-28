/* Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000. */

class ValidPalindrome {

    private Boolean delete = false;

    public boolean palindrome(String s, int i, int j) {
        for(;i<=j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        for(int i=0,j=s.length()-1;i<=j;){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(ci!=cj){
                if(delete){
                    return false;
                }
                else{
                    return (palindrome(s,i+1,j)||palindrome(s,i,j-1));
                    // if(s.charAt(i+1)==s.charAt(j)){
                    //     i++;
                    // }
                    // else if(s.charAt(j-1)==s.charAt(i)){
                    //     j--;
                    // }
                    // else{
                    //     return false;
                    // }
                    // delete = true;
                }
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome foo = new ValidPalindrome();
        System.out.println(foo.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}