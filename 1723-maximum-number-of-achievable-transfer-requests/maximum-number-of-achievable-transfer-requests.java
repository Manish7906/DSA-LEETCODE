class Solution {
    int m;
    int result = Integer.MIN_VALUE;

    private void solve(int idx, int count, int n, int[] resultant, int[][] requests) {
        if (idx == m) {
            boolean allZero = true;
            for (int x : resultant) {
                if (x != 0) {
                    allZero = false;
                    break;
                }
            }

            if (allZero) {
                result = Math.max(result, count);
            }
            return;
        }

        int from = requests[idx][0];
        int to = requests[idx][1];

        // Choose this request
        resultant[from]--;
        resultant[to]++;
        solve(idx + 1, count + 1, n, resultant, requests);

        // Backtrack
        resultant[from]++;
        resultant[to]--;
        solve(idx + 1, count, n, resultant, requests);
    }

    public int maximumRequests(int n, int[][] requests) {
        m = requests.length;
        int[] resultant = new int[n];
        solve(0, 0, n, resultant, requests);
        return result;
    }
}
