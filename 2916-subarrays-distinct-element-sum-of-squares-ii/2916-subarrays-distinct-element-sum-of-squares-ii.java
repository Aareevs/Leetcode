class Solution {
    private static final long MOD = 1_000_000_007L;

    private int n;
    private long[] sum;
    private long[] sumSq;
    private long[] lazy;
    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        sumSq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long answer = 0;

        for (int i = 0; i < n; i++) {
            int value = nums[i];
            int previous = last[value];

            // Distinct counts increase for starts in [previous + 1, i].
            update(1, 0, n - 1, previous + 1, i);

            // Sum of squares for all subarrays ending at i.
            answer = (answer + sumSq[1]) % MOD;

            last[value] = i;
        }

        return (int) answer;
    }

    private void apply(int node, int left, int right, long delta) {
        long length = right - left + 1L;

        // New square sum:
        // sumSq + 2 * delta * oldSum + length * delta^2
        sumSq[node] = (
            sumSq[node]
            + 2L * delta % MOD * sum[node] % MOD
            + length % MOD * delta % MOD * delta % MOD
        ) % MOD;

        sum[node] = (sum[node] + length % MOD * delta % MOD) % MOD;
        lazy[node] = (lazy[node] + delta) % MOD;
    }

    private void push(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;

        apply(node * 2, left, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, right, lazy[node]);

        lazy[node] = 0;
    }

    private void pull(int node) {
        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sumSq[node] = (sumSq[node * 2] + sumSq[node * 2 + 1]) % MOD;
    }

    private void update(
        int node, int left, int right, int queryLeft, int queryRight
    ) {
        if (queryLeft > right || queryRight < left) {
            return;
        }

        if (queryLeft <= left && right <= queryRight) {
            apply(node, left, right, 1);
            return;
        }

        push(node, left, right);

        int mid = left + (right - left) / 2;

        update(node * 2, left, mid, queryLeft, queryRight);
        update(node * 2 + 1, mid + 1, right, queryLeft, queryRight);

        pull(node);
    }
}