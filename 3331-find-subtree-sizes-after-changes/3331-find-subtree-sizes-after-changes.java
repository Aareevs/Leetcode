class Solution {
    List<Integer>[] tree;
    List<Integer>[] same;
    int[] ans;
    char[] s;

    public int[] findSubtreeSizes(int[] parent, String str) {
        int n = parent.length;

        tree = new ArrayList[n];
        same = new ArrayList[26];
        ans = new int[n];
        s = str.toCharArray();

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < 26; i++) {
            same[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        dfs(0, -1);

        return ans;
    }

    void dfs(int node, int parent) {
        ans[node] = 1;

        int c = s[node] - 'a';
        same[c].add(node);

        for (int child : tree[node]) {
            dfs(child, node);
        }

        int newParent = parent;

        if (same[c].size() > 1) {
            newParent = same[c].get(same[c].size() - 2);
        }

        if (newParent != -1) {
            ans[newParent] += ans[node];
        }

        same[c].remove(same[c].size() - 1);
    }
}