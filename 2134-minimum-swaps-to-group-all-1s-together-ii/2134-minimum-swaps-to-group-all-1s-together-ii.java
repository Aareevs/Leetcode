class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int k = 0;

        // Count total 1s
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                k++;
            }
        }

        if (k == 0 || k == n) {
            return 0;
        }

        int ones = 0;
        int maxOnes = 0;

        // Sliding window
        for (int i = 0; i < n + k - 1; i++) {

            if (nums[i % n] == 1) {
                ones++;
            }

            if (i >= k && nums[(i - k) % n] == 1) {
                ones--;
            }

            maxOnes = Math.max(maxOnes, ones);
        }

        return k - maxOnes;
    }
}