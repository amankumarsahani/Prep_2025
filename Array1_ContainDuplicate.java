// 217. Contains Duplicate (https://leetcode.com/problems/contains-duplicate/)

// Input: nums = [1,2,3,1]
// Output: true
// The element 1 occurs at the indices 0 and 3.

import java.util.Arrays;

public class Array1_ContainDuplicate {
    // public static boolean containsDuplicate(int[] nums) {
    //     for(int i = 0;i<nums.length -1;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             if(nums[i] == nums[j]){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,0};
        System.out.println(containsDuplicate(nums));
    }
}
