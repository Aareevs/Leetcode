import java.util.*;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {

        HashMap<Long, Integer> map = new HashMap<>();

        int maxGaps = 0;

        for (int i = 0; i < wall.size(); i++) {

            long position = 0;
            List<Integer> row = wall.get(i);

            for (int j = 0; j < row.size() - 1; j++) {

                position += row.get(j);

                int count = map.getOrDefault(position, 0) + 1;

                map.put(position, count);

                maxGaps = Math.max(maxGaps, count);
            }
        }

        return wall.size() - maxGaps;
    }
}