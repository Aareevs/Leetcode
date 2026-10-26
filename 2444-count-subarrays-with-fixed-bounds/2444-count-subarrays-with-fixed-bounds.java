class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int lastmin = -1;
        int lastmax = -1;
        int lastBad = -1;

        for(int i =0;i<nums.length;i++){
            if (nums[i] < minK || nums[i] > maxK){
                lastBad = i;
            }
            if (nums[i] == minK){
                lastmin = i;
            }
            if (nums[i] == maxK){
                lastmax = i;
            }
            count += Math.max(0,Math.min(lastmin, lastmax)-lastBad);
        }
        return count;
    }
}