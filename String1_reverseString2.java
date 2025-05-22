// 557. Reverse Words in a String III
// https://leetcode.com/problems/reverse-words-in-a-string-iii/description
// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"

public class String1_reverseString2 {

    // public static String reverseCharInString(String s){
    //     String reverseStr = "";
    //     String word = "";
    //     for(int i=0; i <= s.length(); i++){
    //         if(i == s.length() || s.charAt(i) == ' '){
    //             for(int j=word.length();j>0;j--){
    //                 reverseStr += word.charAt(j-1);
    //             }
    //             reverseStr += " ";
    //             word = "";
    //         } else {
    //             word += s.charAt(i);
    //         }
    //     }
    //     return reverseStr.trim();
    // }

    public static String reverseCharInString(String s){
        StringBuilder reverseStr = new StringBuilder();
        StringBuilder word = new StringBuilder();
        s = s.trim();
        for(int i=0; i <= s.length(); i++){
            if(i == s.length() || s.charAt(i) == ' '){
                for(int j=word.length();j>0;j--){
                    reverseStr.append(word.charAt(j-1));
                }
                if (i != s.length()) {
                    reverseStr.append(" ");
                }
                word.setLength(0);
            } else {
                word.append(s.charAt(i));
            }
        }
        return reverseStr.toString();
    }
    
    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        System.out.println(reverseCharInString(str));
    }
}
