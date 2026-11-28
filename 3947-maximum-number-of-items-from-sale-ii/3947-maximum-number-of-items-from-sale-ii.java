import java.util.*;
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        int cheapest = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            cheapest = Math.min(cheapest, item[1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 2 * i; j <= n; j += i) {
                freq[i] += freq[j];
            }
        }

        TreeMap<Integer, Long> map = new TreeMap<>();

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            if (price >= 2L * cheapest) continue;

            long free = (long) freq[factor] - 1;

            if (free > 0) {
                map.put(price, map.getOrDefault(price, 0L) + free);
            }
        }

        long ans = 0;
        long money = budget;

        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            long price = entry.getKey();
            long count = entry.getValue();

            long buy = Math.min(count, money / price);

            ans += buy * 2;
            money -= buy * price;
        }

        ans += money / cheapest;

        return (int) ans;
    }
}