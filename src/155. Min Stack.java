class MinStack {

    /** initialize your data structure here. */
    
    private Stack<Integer> normStack;
    private Stack<Integer> minStack;
    private int min;
    
    
    public MinStack() {
        normStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        normStack.push(x);
        min = Math.min(x, min);
        minStack.push(min);
    }
    
    public void pop() {
        normStack.pop();
        minStack.pop();
        min = minStack.isEmpty()? Integer.MAX_VALUE : minStack.peek();
    }
    
    public int top() {
        return normStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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
