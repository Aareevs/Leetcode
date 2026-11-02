class Solution {
    public int calculate(String s) {

        Stack<Integer> st = new Stack<>();
        int num = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {

                if (op == '+') {
                    st.push(num);
                } 
                else if (op == '-') {
                    st.push(-num);
                } 
                else if (op == '*') {
                    st.push(st.pop() * num);
                } 
                else if (op == '/') {
                    st.push(st.pop() / num);
                }

                op = c;
                num = 0;
            }
        }

        int ans = 0;

        for (int x : st) {
            ans += x;
        }

        return ans;
    }
}