class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        int n=arr.length;

        int nsr[]=new int[n];
        // Arrays.fill(nsr,-1);
        int nsl[]=new int[n];
        Arrays.fill(nsl,-1);
        for(int i=0;i<n;i++)
        {
            while(s1.size()>0 && arr[i]<=arr[s1.peek()])
            {
                int idx = s1.pop();
                nsr[idx] = i;
            }
            s1.push(i);
        }
        while(s1.size()>0)
        {
            int idx = s1.pop();
            nsr[idx] = n;
        }
            
        for(int i=n-1;i>=0;i--)
        {
            while(s2.size()>0 && arr[i]<arr[s2.peek()])
            {
                int idx = s2.pop();
                nsl[idx] = i;
            }

            s2.push(i);
        }
        System.out.println(Arrays.toString(nsr));
        System.out.println(Arrays.toString(nsl));

        long ans=0;
        int mod=1_000_000_000+7;
        for(int i=0;i<n;i++)
        {
            long contriL=(((i-(nsl[i]+1))%mod)*((nsr[i]-i)%mod))%mod;
            long contriR=(nsr[i]-i)%mod;
            long contri=(((contriL+contriR)%mod)*(arr[i]%mod))%mod;
            ans = (ans+contri)%mod;

        }
        return (int)ans;
        
    }
}