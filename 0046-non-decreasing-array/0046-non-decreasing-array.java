class Solution {
    public boolean checkPossibility(int[] nums) {

        int count=0;
        int idx=-1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]>nums[i+1]) {
                idx=i;
                count++;
            }
        }
        if(count==0) return true;

        if(count==1)
        {
            boolean ans=true;
            boolean ans2=true;
            for(int i=0;i<nums.length-1;i++)
            {
                if(i==idx) continue;

                if(i+1==idx)
                {
                    if(nums[i]>nums[i+2])
                    {
                        ans=false;
                        break;
                    }
                }
                else
                {
                    if(nums[i]>nums[i+1])
                    {
                        ans=false;
                        break;
                    }
                }
            }
            for(int i=0;i<nums.length-1;i++)
            {
                if(i==idx+1) continue;

                if(i==idx)
                {
                    if(i+2<nums.length && nums[i]>nums[i+2])
                    {
                        ans2=false;
                        break;
                    }
                }
                else
                {
                    if(nums[i]>nums[i+1])
                    {
                        ans2=false;
                        break;
                    }
                }
            }
            return ans || ans2;
        }
        else
        {
            return false;
        }
    }
}