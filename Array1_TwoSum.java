// 1. Two Sum (https://leetcode.com/problems/two-sum/description/)
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]

public class Array1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for(int i =0 ;i < nums.length - 1 ; i++){
            for(int j= i+1;j<nums.length;j++){
                if(target == nums[i]+nums[j]){
                    // return indexes
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(nums,target).toString());
    }
}