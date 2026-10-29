 class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int invalid = -1;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] < minK || nums[right] > maxK){
                invalid = right;
            }
            count += right - invalid;
        }
        return count;
    }
}