class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean valid = true;
            int prevMax = Integer.MIN_VALUE;

            for (int start = 0; start < n && valid; start += k) {
                int descents = 0;
                int min = nums[start], max = nums[start];

                for (int j = start; j < start + k; j++) {
                    int next = (j + 1 == start + k) ? start : j + 1;
                    if (nums[j] > nums[next]) {
                        descents++;
                        min = nums[next]; 
                        max = nums[j];      
                    }
                }

                if (descents > 1 || prevMax > min) {
                    valid = false;
                } else {
                    prevMax = max;
                }
            }

            if (valid) ans += k;
        }

        return ans;
    }
}