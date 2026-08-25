class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = quantities[0];

        for (int i = 0; i < quantities.length; i++) {
            high = Math.max(high, quantities[i]);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (minmax(quantities, n, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean minmax(int[] quantities, int k, int mid) {

        int store = 0;

        for (int i = 0; i < quantities.length; i++) {

            store += (quantities[i] + mid - 1) / mid;

            if (store > k) {
                return false;
            }
        }

        return true;
    }
}