class Solution {
    // Helper function to check if a number is numerically balanced
    private boolean isBalanced(int num) {
        int[] count = new int[10]; // digits 0-9
        int temp = num;
        while (temp > 0) {
            count[temp % 10]++;
            temp /= 10;
        }
        for (int d = 0; d <= 9; d++) {
            if (count[d] > 0 && count[d] != d) {
                return false;
            }
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        int x = n + 1;
        while (true) {
            if (isBalanced(x)) {
                return x;
            }
            x++;
        }
    }
}
