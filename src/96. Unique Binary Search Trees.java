class Solution {
    public int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;
    
        for(int i=2; i<=n; ++i) {
    	    for(int j=1; j<=i; ++j) {
    		    G[i] += G[j-1] * G[i-j];
    	    }
        }

        return G[n];
    }
}

// DP
// number of BSTs with k being the root = #BSTs of k-1 consecutive numbers * #BSTs of n-k consecutive numbers
/*G(n): the number of unique BST for a sequence of length n.
 *F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges     from 1 to n.
 *G(n) = F(1, n) + F(2, n) + ... + F(n, n). 
 *G(0)=1, G(1)=1. 
 *F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
 *G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 
*/