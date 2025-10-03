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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        collectPaths(root, sum, temp, result);
        return result;
    }

    private void collectPaths(TreeNode root, int curr, List<Integer> temp, List<List<Integer>> result) {
        if (root == null)
            return;
        
        temp.add(root.val);

        if (root.left == null && root.right == null && root.val == curr) {
            result.add(new ArrayList<>(temp));
        }

        collectPaths(root.left, curr - root.val, temp, result);
        collectPaths(root.right, curr - root.val, temp, result);

        temp.remove(temp.size() - 1);
    }
}
/*collectPaths(5, 22, [])
 ├── collectPaths(4, 17, [5])
 │    └── collectPaths(11, 13, [5,4])
 │         ├── collectPaths(7, 2, [5,4,11])
 │         │    └── leaf? 7 != 2 ❌
 │         └── collectPaths(2, 2, [5,4,11])
 │              └── leaf? 2 == 2 ✅ [5,4,11,2]
 │
 └── collectPaths(8, 17, [5])
      ├── collectPaths(13, 9, [5,8])
      │    └── leaf? 13 != 9 ❌
      └── collectPaths(4, 9, [5,8])
           ├── collectPaths(5, 5, [5,8,4])
           │    └── leaf? 5 == 5 ✅ [5,8,4,5]
           └── collectPaths(1, 5, [5,8,4])
                └── leaf? 1 != 5 ❌
 */
 /*Rule of thumb:
Internal node → has children → recurse on each child
Leaf node → no children → recursion immediately returns → only leaf check + backtrack happens */