class Solution {
    public int reverseDegree(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            int ch=s.charAt(i);
            int x=123-(int)ch;
            ans=ans+(x)*(i+1);
        }
        return ans;
    }
}

// 97+26=123