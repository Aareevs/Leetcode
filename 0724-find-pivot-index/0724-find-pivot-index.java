class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        int[] pf = new int[n];
        pf[0] = nums[0];

        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + nums[i];
        }

        int[] sf = new int[n];
        sf[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            sf[i] = sf[i + 1] + nums[i];
        }

        if (sf[1] == 0) {
            return 0;
        }

        for (int i = 1; i < n - 1; i++) {
            if (pf[i - 1] == sf[i + 1]) {
                return i;
            }
        }

        if (pf[n - 2] == 0) {
            return n - 1;
        }

        return -1;
    }
}