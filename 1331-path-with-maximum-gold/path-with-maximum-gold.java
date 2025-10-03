class Solution {
    int m, n;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public int DFS(int[][] grid, int i, int j) {
        if(i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == 0) {
            return 0; //Zero gold
        }

        int originalGoldValue = grid[i][j];
        grid[i][j] = 0;

        int maxGold = 0;

        //up, down, left, right
        for(int[] dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            maxGold = Math.max(maxGold, DFS(grid, new_i, new_j));
        }

        grid[i][j] = originalGoldValue;
        return originalGoldValue + maxGold;
    }

    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int maxGold = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) {
                    //It has gold
                    maxGold = Math.max(maxGold, DFS(grid, i, j));
                }
            }
        }

        return maxGold;
    }
}
//example 2 of leetcode 
/*DFS(0,0)=1
 └─ Down → DFS(1,0)=2
      └─ Down → DFS(2,0)=3
           └─ Right → DFS(2,1)=4
                ├─ Right → DFS(2,2)=5
                │    └─ Up → DFS(1,2)=6
                │         └─ Up → DFS(0,2)=7
                │              ├─ Left (0,1)=0 → 0
                │              ├─ Right (0,3)=OOB → 0
                │              ├─ Up OOB → 0
                │              └─ Down (1,2)=visited → 0
                │              Return = 7
                │         Return = 6 + 7 = 13
                │    Return = 5 + 13 = 18
                ├─ Down → DFS(3,1)=3 (already visited earlier in this path → skip)
                ├─ Left (2,0)=visited
                └─ Up (1,1)=0
                Return = 4 + 18 = 22
           Return = 3 + 22 = 25
      Return = 2 + 25 = 27
 Return = 1 + 27 = 28 ✅
 */
//example 1
/*DFS(1,2)=7
 ├─ Right → out of bounds → 0
 ├─ Left → DFS(1,1)=8
 │    ├─ Up → DFS(0,1)=6 → returns 6
 │    ├─ Down → DFS(2,1)=9 → returns 9
 │    ├─ Left → DFS(1,0)=5 → returns 5
 │    └─ Right → visited → 0
 │    Return = 8 + max(6,9,5,0) = 17
 ├─ Up → 0
 └─ Down → 0
Return = 7 + 17 = 24 ✅
 */ 