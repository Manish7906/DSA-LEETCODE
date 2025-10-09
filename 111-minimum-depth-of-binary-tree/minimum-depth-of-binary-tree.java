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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int lh = minDepth(root.left);
        int rh = minDepth(root.right);

        // handle cases where one subtree is null
        if (root.left == null) return 1 + rh;
        if (root.right == null) return 1 + lh;

        return 1 + Math.min(lh, rh);
    }
}
/*minDepth(3)
├─ minDepth(9)   → leaf → returns 1
└─ minDepth(20)
     ├─ minDepth(15) → leaf → returns 1
     └─ minDepth(7)  → leaf → returns 1
     → minDepth(20) = 1 + min(1,1) = 2
→ minDepth(3) = 1 + min(1,2) = 2
 */
 /*Step-by-Step Example Using (WHY =Integer.MAX_VALUE)
Tree:
     1
    /
   2
Node 2: leaf → return 1
Node 1:
left = minDepth(2) = 1
right = null → Integer.MAX_VALUE
1 + Math.min(left, right) = 1 + Math.min(1, Integer.MAX_VALUE) = 1 + 1 = 2 ✅
Correct! The path 1 → 2 is counted, and the null child is ignored. */
