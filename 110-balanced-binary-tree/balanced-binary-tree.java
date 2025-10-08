/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsheight(root)!=-1;
    }
    int dfsheight(TreeNode root){
        if(root==null) return 0;
        int lh=dfsheight(root.left);
        if(lh==-1) return -1;
        int rh=dfsheight(root.right);
        if(rh==-1) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        return 1+Math.max(lh,rh); 
    }
}
/*
dfsheight(3)
 ├─ dfsheight(9)
 │   ├─ dfsheight(null) → 0
 │   ├─ dfsheight(null) → 0
 │   └─ return 1 + max(0,0) = 1
 │
 ├─ dfsheight(20)
 │   ├─ dfsheight(15)
 │   │   ├─ dfsheight(null) → 0
 │   │   ├─ dfsheight(null) → 0
 │   │   └─ return 1 + max(0,0) = 1
 │   │
 │   ├─ dfsheight(7)
 │   │   ├─ dfsheight(null) → 0
 │   │   ├─ dfsheight(null) → 0
 │   │   └─ return 1 + max(0,0) = 1
 │   │
 │   └─ return 1 + max(1,1) = 2
 │
 └─ return 1 + max(1,2) = 3
*/