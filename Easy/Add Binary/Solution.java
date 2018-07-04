/*Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"*/

class Solution {
    public static String addBinary(String a, String b) {
    	String answer;
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int maxsize = (ac.length > bc.length) ? ac.length : bc.length;
        char[] nc = new char[maxsize];
        boolean add1=false;

        int i=ac.length-1;
        int j=bc.length-1;
        int n=maxsize-1;

        for (;i>=0||j>=0; ) {
        	char aci = (i<0) ? '0': ac[i];
        	char bcj = (j<0) ? '0': bc[j];
        	char add;

        	if(aci=='1'&&bcj=='1'){
        		add = (add1)? '1':'0';
        		add1=true;
        	}
        	else if(aci=='0'&&bcj=='0'){
        		add = (add1)? '1':'0';
        		add1=false;
        	}
        	else{
        		add = (add1)? '0':'1';
        		add1 = (add1)? true:false;
        	}
        	nc[n]=add;
        	// System.out.print(add+" ");
        	i--;
        	j--;
        	n--;
        }
        answer = String.valueOf(nc);;
        // System.out.println("answer1: "+answer);

        if(add1){
        	answer = "1"+answer;
        }
        return answer;
    }

    public static void main(String[] args) {
    	String ans = addBinary("1010", "1011");
    	System.out.println("answer: "+ans);
    }
}