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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(level);
        }
        return result;
    }
}
/*Level 0:
Queue before: [1]
Poll 1 -> row[0]=1, queue add children [2,3]
Result after level: [[1]]

Level 1:
Queue before: [2,3]
Poll 2 -> row[1]=2, queue add children [3,4,5]
Poll 3 -> row[0]=3, queue add children [4,5,6]
Result after level: [[1],[3,2]]

Level 2:
Queue before: [4,5,6]
Poll 4 -> row[0]=4, queue add children []
Poll 5 -> row[1]=5, queue add children []
Poll 6 -> row[2]=6, queue add children []
Result after level: [[1],[3,2],[4,5,6]]
 */