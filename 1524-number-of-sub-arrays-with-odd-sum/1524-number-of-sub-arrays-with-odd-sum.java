class Solution {
    public int numOfSubarrays(int[] arr) {
        int oc=0,ec=0;
        int ans=0;
        int currSum=0;
        int mod=1_000_000_000+7;
        for(int i=0;i<arr.length;i++)
        {
            currSum+=arr[i];
            if((currSum & 1) == 1)
            {
                ans+=1;
                ans+=ec;
                oc++;
            }
            else
            {
                ans+=oc;
                ec++;
            }
            ans=ans%mod;
        }
        return ans;
    }
}