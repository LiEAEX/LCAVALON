http://www.cnblogs.com/grandyang/p/7200016.html

Runtime: 63 ms, faster than 55.05% of Java online submissions for Smallest Range.
Memory Usage: 48.3 MB, less than 81.67% of Java online submissions for Smallest Range.

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.isEmpty()) return null;
        
        Queue<List<Integer>> pq = new PriorityQueue<>((a, b)->a.get(0) - b.get(0));

        int max = Integer.MIN_VALUE;
        
        for (List<Integer> list:nums){
            pq.offer(list); 
            max = Math.max(max, list.get(0));
        }
        
        int[] res = new int[2];
        int range = Integer.MAX_VALUE;
        
        while (pq.size() == nums.size()){// 当某个list的数字遍历完了就结束循环，因为我们的范围要cover每个list至少一个数字
            if (max - pq.peek().get(0) < range){
                range = max - pq.peek().get(0);
                res[0] = pq.peek().get(0);
                res[1] = max;
            }
            List<Integer> temp = pq.poll();
            temp.remove(0);
            if (!temp.isEmpty()){
                pq.offer(temp);
                max = Math.max(max, temp.get(0));// 每次更新max为当前遇到的最大值
            }
        }
        return res;
    }        
}

class Range {
    int start;
    int end;
    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums.size() == 1) {
            int a = nums.get(0).get(0);
            int[] res = new int[]{a, a};
            return res;
        }
        List<Range> list = new ArrayList<>();
        for (int a : nums.get(0)) {
            list.add(new Range(a, a));
        }
        for (int i = 1; i < nums.size(); i++) {
            list = merge(list, nums.get(i));
        }
        return getShortestRange(list);
    }
    private List<Range> merge(List<Range> list, List<Integer> num) {
        List<Range> res = new ArrayList<>();
        int i = 0; 
        int j = 0; 
        while (j < num.size() && i < list.size()) {
            if (num.get(j) <= list.get(i).end) {
                if (j != num.size() - 1 && num.get(j + 1) <= list.get(i).end) {
                    j++;
                } else if (num.get(j) < list.get(i).start) {
                    res.add(new Range(num.get(j), list.get(i).end));
                    j++;
                } else {
                    res.add(new Range(list.get(i).start, list.get(i).end));
                    i++;
                }
            } else if (i != list.size() - 1 && num.get(j) >= list.get(i + 1).end) {
                i++;
            } else {
                res.add(new Range(list.get(i).start, num.get(j)));
                i++;
            }
        }
        return res;
    }
    private int[] getShortestRange(List<Range> list) {
        Range res = list.get(0);
        int diff = res.end - res.start;
        for (Range r : list) {
            if (r.end - r.start < diff) {
                diff = r.end - r.start;
                res = r;
            }
        }
        return new int[]{res.start, res.end};
    }
}



O(n log n):

class Solution {

    class NG{
        int num;
        int group;
        NG(int num, int group){
            this.num=num;
            this.group=group;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        List<NG> list = new ArrayList<>();
        for(int g = 0 ; g < nums.size(); g++){
            for(Integer i : nums.get(g)){
                list.add(new NG(i, g)); // put in the list all the (number, group) pairs
            }
        }
        Collections.sort(list, (a, b) -> Integer.compare(a.num, b.num)); // sort by number
                
        int resL=0; int resR=list.size(); // result left/right pointers. right is not inclusive
        int l = 0 ; int r = 0; // window left/right pointers. right is not inclusive
        int groups = 0; // number of groups inside of the sliding window
        int [] groupsCount = new int[nums.size()]; // index is group, value is how many values of group inside of the window
        while(l < list.size()){
            if(groups<nums.size() && r < list.size()){ // not all groups in the window
                r++;
                NG ng = list.get(r-1);
                groupsCount[ng.group]++;
                if(groupsCount[ng.group] == 1) groups++;
            }else{ // all groups in the window
                NG ng = list.get(l);
                groupsCount[ng.group]--;
                if(groupsCount[ng.group] == 0) groups--;
                l++;

            }
    // if all the groups in the window check if window is smaller then current result
            if(groups == nums.size()){
                if(list.get(resR-1).num - list.get(resL).num > 
                   list.get(r-1).num - list.get(l).num){
                    resL=l;resR=r;
                }
            }
        }
        return new int[]{list.get(resL).num, list.get(resR-1).num};
    }
}