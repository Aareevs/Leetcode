class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currsum=nums[0];
        int maxsum=nums[0];
        int minend=nums[0];
        int minsum=nums[0];
        for(int i=1;i<nums.length;i++){
           
            currsum=Math.max(nums[i],(currsum+nums[i]));
            maxsum=Math.max(currsum,maxsum);
            //----
            minend=Math.min(nums[i],(minend+nums[i]));
            minsum=Math.min(minend,minsum);

        }
        
        return Math.max(maxsum,(Math.abs(minsum)));

    }
}