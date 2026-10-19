class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length())
            return "";

        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }

        int k = t.length();
        int n = s.length();

        int cm = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        int i = 0, j = 0;

        while (j < n) {

            // acquire or adding part cm plus 1 hoga yaha pe 
            char ch = s.charAt(j);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);

            if (tmap.containsKey(ch) &&
                    smap.get(ch) <= tmap.get(ch)) {
                cm++;
            }

            while (cm == k) {

                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }

                //remove wala part yaha pe cm minus 1 hoga
                char left = s.charAt(i);

                if (tmap.containsKey(left) &&
                        smap.get(left) <= tmap.get(left)) {
                    cm--;
                }

                smap.put(left, smap.get(left) - 1);

                if (smap.get(left) == 0) {
                    smap.remove(left);
                }

                i++;
            }

            j++;
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}