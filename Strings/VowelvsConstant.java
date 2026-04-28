package Strings;

import java.util.Scanner;

public class VowelvsConstant {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       sc.nextLine();
       while(N>0)
       {
           String str = sc.nextLine();
           int L = str.length();
           int vowel=0;
           int cons=0;
           for(int i=0;i<L;i++)
           {
               char ch = str.charAt(i);
               if(ch == 'a' || ch== 'e' || ch == 'i' || ch == 'o' || ch == 'u')
               {
                   vowel++;
               }
               else
               {
                   cons++;
               }
           }
           System.out.println(vowel + " " + cons);
           N--;
       }
    }
}
