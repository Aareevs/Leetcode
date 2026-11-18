class Solution {
    public int numberOfAlternatingGroups(int[] colors) {

        int n=colors.length;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            int x=colors[i%n];
            int y=colors[(i+1)%n];
            int z=colors[(i+2)%n];


            if(x==z && x!=y) ans++;

        }
        return ans;
    }
}