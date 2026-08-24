class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            int requiredDays = 1;
            int currentLoad = 0;

            for (int w : weights) {
                if (currentLoad + w > mid) {
                    requiredDays++;
                    currentLoad = 0;
                }
                currentLoad += w;
            }

            if (requiredDays <= days) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}