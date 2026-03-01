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

    public boolean isValidBST(TreeNode root) {

        // Step 1: Store inorder traversal
        List<Integer> inOrderList = new ArrayList<>();
        helper(root, inOrderList);

        // Step 2: Check if strictly increasing
        for (int i = 1; i < inOrderList.size(); i++) {
            if (inOrderList.get(i) <= inOrderList.get(i - 1)) {
                return false;   // BST property violated
            }
        }

        return true;
    }

    // Inorder Traversal Function
    private void helper(TreeNode node, List<Integer> inOrderList) {

        if (node == null)
            return;

        helper(node.left, inOrderList);     // Left
        inOrderList.add(node.val);          // Root
        helper(node.right, inOrderList);    // Right
    }
}