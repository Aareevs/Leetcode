class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int gcd = 0;

        for (int count : map.values()) {
            gcd = findGcd(gcd, count);
        }

        return gcd >= 2;
    }

    public int findGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}