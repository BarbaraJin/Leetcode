package easy;

import java.util.Date;

public class BitwiseComplement {
    public static int bitwiseComplement(int n) {
        String input = Integer.toBinaryString(n);
        StringBuilder answer = new StringBuilder();
        for(char c : input.toCharArray()){
            answer.append(c == '0'? '1':'0');
        }
        return Integer.parseInt(answer.toString(), 2);
    }

    public static int bitwiseComplement2(int n) {
        System.out.println("input: "+ n);
        System.out.println("log2n: "+ ((int) (Math.log(n)/Math.log(2d))));
        System.out.println("decimal of log2n and shift: "+ ((2<<((int) (Math.log(n)/Math.log(2d))))));
        System.out.println("binary of log2n and shift: "+ (Integer.toBinaryString((2<<((int) (Math.log(n)/Math.log(2d)))))));
        System.out.println("c: "+ ((2<<'c')));
        System.out.println("binary of log2n and shift and -1: "+ (Integer.toBinaryString((2<<((int) (Math.log(n)/Math.log(2d))))-1)));
        System.out.println("binary of n: "+ (Integer.toBinaryString(n)));
        System.out.println("binary of log2n and shift and -1 - n: "+ (Integer.toBinaryString((2<<((int) (Math.log(n)/Math.log(2d))))-1 - n)));
        return (2<<((int) (Math.log(n)/Math.log(2d))))-1 -n;
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("town1: " + bitwiseComplement2(5));
        System.out.println("town2: " + bitwiseComplement2(7));
        System.out.println("town3: " + bitwiseComplement2(1));
        System.out.println("town4: " + bitwiseComplement2(0));
        Date start = new Date();
        System.out.println("town5: " + bitwiseComplement2(99999999));
        System.out.println("run time: " + (new Date().getTime() - start.getTime()));
    }
}
