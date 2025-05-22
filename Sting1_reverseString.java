// 151. Reverse Words in a String (https://leetcode.com/problems/reverse-words-in-a-string/)
// Input: s = "the sky is blue"
// Output: "blue is sky the"

import java.util.Scanner;

public class Sting1_reverseString {

    public static String reverseString(String s){
        String[] arr = s.split("\\s+");
        String reverseVal = "";
        for(int i=arr.length-1;i>= 0;i--){
            reverseVal += arr[i];
            reverseVal += " ";
        }
        return reverseVal.trim();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.close();
        System.out.println(reverseString(input.trim()));
    }
}