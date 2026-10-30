class Solution {
    public int maxSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;

        for (int num : nums) {
            int d = digit(num);

            if (map.containsKey(d)) {
                ans = Math.max(ans, num + map.get(d));
                map.put(d, Math.max(num, map.get(d)));
            } else {
                map.put(d, num);
            }
        }

        return ans;
    }

    public int digit(int num) {
        int x = 0;

        while (num > 0) {
            x = Math.max(x, num % 10);
            num /= 10;
        }

        return x;
    }
}