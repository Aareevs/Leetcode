class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newResult = new ArrayList<>();

            for (List<Integer> list : result) {
                for (int i = 0; i <= list.size(); i++) {
                    if (i > 0 && list.get(i - 1) == num)
                        break;

                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(i, num);

                    if (!newResult.contains(temp)) {
                        newResult.add(temp);
                    }
                }
            }

            result = newResult;
        }

        return result;
    }
}