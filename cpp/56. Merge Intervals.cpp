// 如1-6 2-4 3-8 -> 1-4 2-6 3-8 merge后的区间与把开始阶段，结束阶段的时间都sort，merge结果是不变的   -> 某种可证明的特性
// 如果start的i+1大于end的i，则说明前面的区间是独立的，和后面不重叠

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> res;
        vector<int> s;
        vector<int> e;
        for (int i = 0; i < intervals.size(); i++) {
            s.push_back(intervals[i][0]);
            e.push_back(intervals[i][1]);
        }
        sort(s.begin(), s.end());
        sort(e.begin(), e.end());
        for (int i = 0, j = 0; i < intervals.size(); i++) {
            if (i == intervals.size() - 1 || s[i + 1] > e[i]) {
                res.push_back({s[j], e[i]});
                j = i + 1;
            }
        }
        return res;
    }
};
