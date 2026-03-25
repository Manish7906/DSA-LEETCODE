class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Step 1: Calculate total sum using long
        long total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }

        // Step 2: If total is odd → not possible
        if (total % 2 != 0) return false;

        long target = total / 2;

        // Step 3: Check horizontal cut
        long curr = 0;
        for (int i = 0; i < m - 1; i++) { // ensure non-empty parts
            long rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            curr += rowSum;

            if (curr == target) return true;
        }

        // Step 4: Check vertical cut
        curr = 0;
        for (int j = 0; j < n - 1; j++) {
            long colSum = 0;
            for (int i = 0; i < m; i++) {
                colSum += grid[i][j];
            }
            curr += colSum;

            if (curr == target) return true;
        }

        return false;
    }
}