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
    private int maxDepth;
    private int bottomLeft;

    private void solve(TreeNode root, int currDepth) {
        if (root == null) {
            return;
        }

        // If we reach a new deeper level, update bottomLeft
        if (currDepth > maxDepth) {
            maxDepth = currDepth;
            bottomLeft = root.val;
        }

        // Important: go left first so we visit leftmost nodes first
        solve(root.left, currDepth + 1);
        solve(root.right, currDepth + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        maxDepth = -1;
        solve(root, 0);
        return bottomLeft;
    }
}

/*        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7
| Call (node, depth) | Condition (`currDepth > maxDepth`) | Updates                          |
| ------------------ | ---------------------------------- | -------------------------------- |
| (1, 0)             | true (0 > -1)                      | `bottomLeft = 1`, `maxDepth = 0` |
| (2, 1)             | true (1 > 0)                       | `bottomLeft = 2`, `maxDepth = 1` |
| (4, 2)             | true (2 > 1)                       | `bottomLeft = 4`, `maxDepth = 2` |
| (3, 1)             | false                              | —                                |
| (5, 2)             | false                              | —                                |
| (7, 3)             | true (3 > 2)                       | `bottomLeft = 7`, `maxDepth = 3` |
| (6, 2)             | false                              | —                                |
 */