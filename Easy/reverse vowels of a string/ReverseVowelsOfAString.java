import java.util.Arrays;
import java.util.List;

class ReverseVowelsOfAString {

    private static List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');

    public String reverseVowels(String s) {
        char[] answer = new char[s.length()];
        for(int i=0,j=s.length()-1;i<=j;){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!vowels.contains(ci)){
                answer[i]=ci;
                i++;
            }
            else if(!vowels.contains(cj)){
                answer[j]=cj;
                j--;
            }
            else{
                answer[i]=cj;
                answer[j]=ci;
                i++;
                j--;
            }
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString test = new ReverseVowelsOfAString();
        String answer = test.reverseVowels("oooooe");
        System.out.println(answer);
    }
}