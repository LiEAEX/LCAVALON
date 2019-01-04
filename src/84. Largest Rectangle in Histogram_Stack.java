// Stack Approach

class Solution {
    public int largestRectangleArea(int[] height) {
        int res = 0;
        Stack<Integer> st = new Stack<>();
        int[] heights = new int[height.length + 1];
        for (int i = 0; i < height.length; ++i){
            heights[i] = height[i];
        }
        heights[height.length] = 0; // 高度数组最后面加上一个0，处理最后一个板子
        for (int i = 0; i < heights.length; ++i) {
            while (!st.empty() && heights[st.peek()] >= heights[i]) { // 栈非空且新高度小于栈顶部元素
                int cur = st.peek(); 
                st.pop();
                res = Math.max(res, heights[cur] * (st.empty() ? i : (i - st.peek() - 1)));
            }
            st.push(i); // 栈中存取的是位置（坐标）而不是高度
        }
        return res;
    }
}
/*
递增栈是维护递增的顺序，当遇到小于栈顶元素的数就开始处理，而递减栈正好相反，维护递减的顺序，当遇到大于栈顶元素的数开始处理。

那么根据这道题的特点，我们需要按从高板子到低板子的顺序处理，先处理最高的板子，宽度为1，然后再处理旁边矮一些的板子，此时长度为2，
因为之前的高板子可组成矮板子的矩形 ，因此我们需要一个递增栈，当遇到大的数字直接进栈，而当遇到小于栈顶元素的数字时，
就要取出栈顶元素进行处理了，那取出的顺序就是从高板子到矮板子了，于是乎遇到的较小的数字只是一个触发，表示现在需要开始计算矩形面积了，
为了使得最后一块板子也被处理，这里用了个小trick，在高度数组最后面加上一个0，这样原先的最后一个板子也可以被处理了。由于栈顶元素是矩形的高度，
那么关键就是求出来宽度，那么跟之前那道Trapping Rain Water一样，单调栈中不能放高度，而是需要放坐标。由于我们先取出栈中最高的板子，
那么就可以先算出长度为1的矩形面积了，然后再取下一个板子，此时根据矮板子的高度算长度为2的矩形面积，以此类推，知道数字大于栈顶元素为止，再次进栈

相关总结：
http://www.cnblogs.com/grandyang/p/8887985.html
*/