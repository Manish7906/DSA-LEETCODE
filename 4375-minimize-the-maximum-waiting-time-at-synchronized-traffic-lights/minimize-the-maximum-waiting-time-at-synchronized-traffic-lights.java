
class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {

        int maxGreen = 0;

        // Find maximum green duration
        for (int light : lights) {
            maxGreen = Math.max(maxGreen, light);
        }

        int ans = 0;

        // Calculate waiting time for each car
        for (int time : arrivalTime) {

            int r = time % period;

            if (r >= maxGreen) {
                int wait = period - r;
                ans = Math.max(ans, wait);
            }
        }

        return ans;
    }
}
