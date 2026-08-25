class Solution {
    public int largestAltitude(int[] gain) {
        
        int[] pf = new int[gain.length + 1];
        pf[0] = 0;

        int max = 0;

        for (int i = 1; i < pf.length; i++) {
            pf[i] = pf[i - 1] + gain[i - 1];
            max = Math.max(max, pf[i]);
        }
        return max;

    }
}