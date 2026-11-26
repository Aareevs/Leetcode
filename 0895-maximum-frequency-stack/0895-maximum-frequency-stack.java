class FreqStack {
    HashMap<Integer,Integer> freq;
    HashMap<Integer, Stack<Integer>> group;
    int maxFreq;
    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val,0)+1;
        freq.put(val,f);
        group.putIfAbsent(f, new Stack<>());
        group.get(f).push(val);
        maxFreq = Math.max(maxFreq,f);
    }
    
    public int pop() {
        Stack<Integer> st = group.get(maxFreq);
        int val = st.pop();
        freq.put(val, freq.get(val)-1);
        if(st.size()==0){
            maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */