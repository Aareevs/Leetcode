class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer,Integer> rm = new HashMap<>();
        HashMap<Integer,Integer> cm = new HashMap<>();
        HashMap<Integer,Integer> pd = new HashMap<>();
        HashMap<Integer,Integer> ad = new HashMap<>();
        HashMap<Long,Integer> pos = new HashMap<>();

        for(int[] arr:lamps)
        {
            int row=arr[0];
            int col=arr[1];
            int pri=row-col;
            int anti=row+col;
            long lamp = (long)row*n+col;

            if (pos.containsKey(lamp)) continue;

            rm.put(row,rm.getOrDefault(row,0)+1);
            cm.put(col,cm.getOrDefault(col,0)+1);
            pd.put(pri,pd.getOrDefault(pri,0)+1);
            ad.put(anti,ad.getOrDefault(anti,0)+1);
            pos.put(lamp,1);
        }

        int ans[]=new int[queries.length];
        int k=0;
        for(int[] arr:queries)
        {
            int row=arr[0];
            int col=arr[1];
            int pri=row-col;
            int anti=row+col;
            long lamp = (long)row*n+col;

            if(rm.containsKey(row) || cm.containsKey(col) || pd.containsKey(pri) || ad.containsKey(anti))
            {
                ans[k]=1;
            }
            k++;

            //remove adjacent lamps logic

            int adj[][]={{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}};
            for(int[] mat:adj)
            {
                int x=mat[0];
                int y=mat[1];
                int r=row+x;
                int c=col+y;
                if (r<0 || r>=n || c<0 || c>=n) continue;
                long posi=(long)r*n+c;
                int pdiag=r-c;
                int adiag=r+c;

                if(pos.containsKey(posi))
                {
                    rm.put(r,rm.get(r)-1);
                    cm.put(c,cm.get(c)-1);
                    pd.put(pdiag,pd.get(pdiag)-1);
                    ad.put(adiag,ad.get(adiag)-1);
                    pos.remove(posi);

                    if(rm.get(r)==0) rm.remove(r);
                    if(cm.get(c)==0) cm.remove(c);
                    if(pd.get(pdiag)==0) pd.remove(pdiag);
                    if(ad.get(adiag)==0) ad.remove(adiag);
                }
            }
        }
        return ans;
    }
}