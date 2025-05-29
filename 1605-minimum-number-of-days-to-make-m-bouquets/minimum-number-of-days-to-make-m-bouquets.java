import java.util.Arrays;
class Solution {
    public boolean bouquets(int bloomDay[], int day, int m, int k) {
        if (bloomDay.length < m * k) return false;
        int count = 0;
        int numberOfBouquet = 0;
        for (int j = 0; j < bloomDay.length; j++) {
            if (bloomDay[j] <= day) {
                count++;
                if (count == k) {
                    numberOfBouquet++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return numberOfBouquet >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < m * k) return -1;
        int high = Arrays.stream(bloomDay).max().orElseThrow();
        int low = Arrays.stream(bloomDay).min().orElseThrow();
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (bouquets(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
