For a valid BST, there must be a node that is the root. The root can be any number between 1 and n. What if the root is k where k is in between 1 and n? It becomes obvious that 1 to k-1 should be k's left children and k+1 to n should be k's right children. Thus, a recursive formula is formulated as follows:

number of BSTs with k being the root 
= count of BSTs of k-1 consecutive numbers * count of BSTs of n-k consecutive numbers

And since we have a total of n choices for k, total number of BSTs is thus a sum of all n choices for k.

public int numTrees(int n) {
    return numTrees(n, new int[n]);
}

private int numTrees(int n, int[] arr) {
    if(n<=1) return 1;
    if(arr[n-1] > 0) return arr[n-1];
    
    int num = 0;
    for(int i=1; i<=n; i++) 
        num = num + numTrees(i-1, arr) * numTrees(n-i, arr);

    arr[n-1] = num; // store for reuse
    return num;
}