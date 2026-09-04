class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for (int v : nums) {
            x ^= v;
        }
        int m = x & -x;
        int y = 0;
        int z = 0;
        for (int v : nums) {
            if ((v & m) != 0) {
                y ^= v;
            } else {
                z ^= v;
            }
        } 
        return new int[]{y, z};
    }
}