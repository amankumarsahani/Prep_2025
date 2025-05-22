// 242. Valid Anagram (https://leetcode.com/problems/valid-anagram/)
// Input: s = "anagram", t = "nagaram"
// Output: true

import java.util.Arrays;

public class String1_validAnagarm {
    public static boolean isAnagram(String s, String t) {
        // if(s.length() != t.length()){
        //     return false;
        // }

        // StringBuilder temp = new StringBuilder(t);
        // for(int i =0; i< s.length();i++){
        //     char chk = s.charAt(i);
        //     int index = temp.indexOf(String.valueOf(chk));
        //     if(index != -1){
        //         temp.deleteCharAt(index);
        //     }
        // }
        // return temp.length()==0?true:false;

        char[] st = s.toCharArray();
        char[] tt = t.toCharArray();

        if(st.length != tt.length){
            return false;
        }

        Arrays.sort(st);
        Arrays.sort(tt);

        for(int i=0; i<tt.length; i++){
            if(st[i] != tt[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}
