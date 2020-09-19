public class Assignment22 {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and outprint its sum.
     *
     * Example 1:
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * Example 2:
     * Input: nums = [1]
     * Output: 1
     */

    public static void main(String[] args) {
        //write your code here
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = maxSubArray(nums);
        System.out.println(maxSum);
    }

    public static int maxSubArray(int[] nums) {
        //write your code here
        int size = nums.length; 
        int globalMax = 0;
        int localMax = 0; 

        for (int i = 0; i < size; i++){ 
            localMax += nums[i]; 
            if (globalMax < localMax){
                globalMax = localMax; 
            } 
        } 
        return globalMax; 
    }

}