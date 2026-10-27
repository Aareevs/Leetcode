class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newResult = new ArrayList<>();

            for (List<Integer> list : result) {
                for (int i = 0; i <= list.size(); i++) {
                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(i, num);
                    newResult.add(temp);
                }
            }

            result = newResult;
        }

        return result;
    }
}