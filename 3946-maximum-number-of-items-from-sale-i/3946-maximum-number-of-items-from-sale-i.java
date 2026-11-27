class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] free = new int[n];
        int cheapest = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            cheapest = Math.min(cheapest, items[i][1]);

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    free[i]++;
                }
            }
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int value = 1 + free[i];

            for (int money = budget; money >= price; money--) {
                dp[money] = Math.max(dp[money], dp[money - price] + value);
            }
        }

        int ans = 0;

        for (int money = 0; money <= budget; money++) {
            ans = Math.max(ans, dp[money] + (budget - money) / cheapest);
        }

        return ans;
    }
}