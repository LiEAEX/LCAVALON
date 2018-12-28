class MaxStack {

    /** initialize your data structure here. */
    Stack<Integer> m;
    public MaxStack() {
        m = new Stack<>();
    }
    
    public void push(int x) {
        m.push(x);
    }
    
    public int pop() {
        if (m.empty()) return -1*10^7;
        //m.pop();
        return m.pop();
    }
    
    public int top() {
        if (m.empty()) return -1*10^7;
        return m.peek();
    }
    
    public int peekMax() {
        if (m.empty()) return -1*10^7;
        int max = -1*10^7;
        for (int a : m){
           max = Math.max(a, max); 
        }
        return max;
    }
    
    public int popMax() {
        if (m.empty()) return -1*10^7;
        int b = peekMax(), c = m.size(), record = 0;
        int[] tp = new int[c];
        for (int i = 0; i < c; i++){
            tp[i] = m.pop();
            if (tp[i] == b){
                record = i;
                break;
            }
        }
        for (int i = record - 1; i > -1; i--){
           m.push(tp[i]);
        }
        return b;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */