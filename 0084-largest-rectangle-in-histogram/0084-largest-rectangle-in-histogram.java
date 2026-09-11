class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] nsr = func1(heights);
        int[] nsl = func2(heights);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int height = heights[i];

            // Number of bars that can be included
            int width = nsr[i] - nsl[i] - 1;

            int area = height * width;

            ans = Math.max(ans, area);
        }

        return ans;
    }

    // Next Smaller Element to Right - Func1
    public int[] func1(int[] heights) {
        int n = heights.length;
        int[] nsr = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = st.peek();
            }

            st.push(i);
        }

        return nsr;
    }

    // Next Smaller Element to Left - Func2
    public int[] func2(int[] heights) {
        int n = heights.length;
        int[] nsl = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }

            st.push(i);
        }

        return nsl;
    }
}

