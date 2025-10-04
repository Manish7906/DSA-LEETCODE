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

    Map<Integer, Integer> mp = new HashMap<>();

    private void DFS(TreeNode root, int currLevel) {
        if (root == null) 
            return;

        mp.put(currLevel, mp.getOrDefault(currLevel, 0) + root.val);

        DFS(root.left, currLevel + 1);
        DFS(root.right, currLevel + 1);
    }

    public int maxLevelSum(TreeNode root) {
        mp.clear();
        DFS(root, 1);

        int maxSum = Integer.MIN_VALUE;
        int result = 0;

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int level = entry.getKey();
            int sum   = entry.getValue();

            if (sum > maxSum) {
                maxSum = sum;
                result = level;
            }
        }

        return result;
    }
}
/*| Step | Function Call      | Action                               | Map `mp`         |
| ---- | ------------------ | ------------------------------------ | ---------------- |
| 1    | DFS(1,1)           | Add 1 to level 1                     | {1:1}            |
| 2    | DFS(7,2)           | Add 7 to level 2                     | {1:1, 2:7}       |
| 3    | DFS(7,3)           | Add 7 to level 3 (leaf)              | {1:1, 2:7, 3:7}  |
| 4    | return to DFS(7,2) | Finished left child                  | {1:1, 2:7, 3:7}  |
| 5    | DFS(-8,3)          | Add -8 to level 3 (leaf)             | {1:1, 2:7, 3:-1} |
| 6    | return to DFS(7,2) | Finished right child                 | {1:1, 2:7, 3:-1} |
| 7    | return to DFS(1,1) | Finished left subtree                | {1:1, 2:7, 3:-1} |
| 8    | DFS(0,2)           | Add 0 to level 2 (leaf)              | {1:1, 2:7, 3:-1} |
| 9    | return to DFS(1,1) | Finished right subtree               | {1:1, 2:7, 3:-1} |
| 10   | End                | DFS complete → compute max level sum | Result: 2        |
 */