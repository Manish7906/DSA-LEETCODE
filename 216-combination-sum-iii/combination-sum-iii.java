class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int k, int n, List<Integer> path, List<List<Integer>> result) {
        // Base case
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Stop if invalid
        if (k < 0 || n < 0) return;

        // Try all numbers from current start
        for (int i = start; i <= 9; i++) {
            path.add(i);                     // choose
            backtrack(i + 1, k - 1, n - i, path, result); // explore
            path.remove(path.size() - 1);    // un-choose (backtrack)
        }
    }
}
/*backtrack(start=1, k=3, n=7, path=[])
│
├── Choose 1 → backtrack(2, 2, 6, [1])
│   │
│   ├── Choose 2 → backtrack(3, 1, 4, [1,2])
│   │   │
│   │   ├── Choose 3 → backtrack(4, 0, 1, [1,2,3]) ❌ sum < n
│   │   ├── Choose 4 → backtrack(5, 0, 0, [1,2,4]) ✅ valid → [1,2,4]
│   │   ├── Choose 5 → backtrack(6, 0, -1, [1,2,5]) ❌ sum > n
│   │   └── ...
│   │
│   ├── Choose 3 → backtrack(4, 1, 3, [1,3])
│   │   ├── Choose 4 → backtrack(5, 0, -1, [1,3,4]) ❌
│   │   └── ...
│   │
│   ├── Choose 4 → backtrack(5, 1, 2, [1,4]) ❌
│   └── ...
│
├── Choose 2 → backtrack(3, 2, 5, [2])
│   ├── Choose 3 → backtrack(4, 1, 2, [2,3])
│   └── ...
│
├── Choose 3 → backtrack(4, 2, 4, [3])
│   ├── Choose 4 → backtrack(5, 1, 0, [3,4]) ❌ (need 3 elements)
│   └── ...
│
└── (continues up to 9)
*/