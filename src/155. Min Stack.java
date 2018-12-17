class MinStack {
    Stack<Integer> haha = new Stack<Integer>();

    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        haha.push(x);
    }
    
    public void pop() {
        if (haha.empty()) return;
        haha.pop();
    }
    
    public int top() {
        return haha.peek();
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int a : haha){
            min = Math.min(a, min);
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */