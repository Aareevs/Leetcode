import java.util.*;

class Solution {
    long base = 1000003;
    long mod = 1_000_000_007;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        long[] power = new long[n + 1];

        power[0] = 1;

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = (prefix[i] * base + nums[i]) % mod;
            power[i + 1] = (power[i] * base) % mod;
        }

        int left = 1;
        int right = n;

        while (left < right) {
            int mid = (left + right) / 2;

            if (isUnique(mid, nums, prefix, power)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isUnique(int len, int[] nums,
                             long[] prefix, long[] power) {

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i + len <= nums.length; i++) {

            long hash = (prefix[i + len]
                    - prefix[i] * power[len]) % mod;

            if (hash < 0) {
                hash += mod;
            }

            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}