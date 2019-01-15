Union Find

ref:"https://blog.csdn.net/dm_vincent/article/details/7655764" 


class Solution {
    
    class UnionFind {
        private int count = 0;
        private int[] parent, size;
        
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < n; i++){
                size[i] = 1;
            }  
        }
        
        public int find(int p) { // 路径压缩，寻找p的根节点，其对应序号就是所属于的组
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];    
                p = parent[p];
            }
            return p;
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            count--;
        }
        
        public int count() {
            return count;
        }
    }
    
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }
}