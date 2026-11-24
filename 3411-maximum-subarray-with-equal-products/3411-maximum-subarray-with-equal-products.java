class Solution {
    public int maxLength(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            int product = 1;
            int gcd = 0;
            int lcm = 1;

            for (int j = i; j < nums.length; j++) {

                product *= nums[j];

                gcd = gcd(gcd, nums[j]);

                lcm = lcm(lcm, nums[j]);

                if (product == gcd * lcm) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}