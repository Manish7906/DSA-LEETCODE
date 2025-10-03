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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        // Leaf node check
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        // Recurse left and right with remaining sum
        return hasPathSum(root.left, sum - root.val) || 
               hasPathSum(root.right, sum - root.val);
    }
}
/*hasPathSum(5,22)
├─ hasPathSum(4,17)
│  ├─ hasPathSum(11,13)
│  │  ├─ hasPathSum(7,2)   → false
│  │  └─ hasPathSum(2,2)   → true ✅
│  └─ null → false
└─ hasPathSum(8,17) → false (not needed, left already true)
 */
