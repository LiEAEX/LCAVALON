Runtime: 120 ms, faster than 99.78% of Java online submissions for Find Median from Data Stream.
Memory Usage: 67 MB, less than 49.10% of Java online submissions for Find Median from Data Stream.

class MedianFinder {
    /*The basic idea is to maintain two heaps: a max-heap and a min-heap. 
    *The max heap stores the smaller half of all numbers 
    *The min heap stores the larger half of all numbers
    */

    /** initialize your data structure here. */
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    
    public MedianFinder() {
        // heap is a minimal heap by default, ascending order
        minHeap = new PriorityQueue<>();
        // reverse to a maximum heap, descending order
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()){            
            return (maxHeap.peek() + minHeap.peek()) / 2.0; 
        } else {
            return maxHeap.peek();
        }
    }
}

Difference between add() and offer() in Queue:
"difference is in the contract, that when element can not be added to collection" 
"the add method throws an exception and offer doesn't."

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

Runtime: 555 ms, faster than 5.00% of Java online submissions for Find Median from Data Stream.
Memory Usage: 69.6 MB, less than 6.61% of Java online submissions for Find Median from Data Stream.

class MedianFinder {

    /** initialize your data structure here. */
    ArrayList<Integer> arr;
    public MedianFinder() {
        arr = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
        arr.add(num);
    }
    
    public double findMedian() {
        double res = 0;
        if (arr.isEmpty()) return res;
        Collections.sort(arr);
        if (arr.size() % 2 == 0){
            res = ((double)arr.get(arr.size()/2-1)+(double)arr.get(arr.size()/2))/2;
        } else if (arr.size() % 2 == 1){
            res = ((double)arr.get(arr.size()/2));
        }
        return res;
    }
}

