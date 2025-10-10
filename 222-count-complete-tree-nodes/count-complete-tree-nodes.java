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
    // Recursive function to find leftmost height
    public int leftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + leftHeight(root.left);
    }

    // Recursive function to find rightmost height
    public int rightHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + rightHeight(root.right);
    }

    // Main function to count nodes in a complete binary tree
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = leftHeight(root);
        int rh = rightHeight(root);

        // If both sides have the same height -> perfect binary tree
        if (lh == rh) {
            // Use Math.pow as you requested
            return (int)(Math.pow(2, lh) - 1);
        }

        // Otherwise, recursively count left + right + root
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}