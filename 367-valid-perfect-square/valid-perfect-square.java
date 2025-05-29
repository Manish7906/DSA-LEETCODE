class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > num / mid) {
                high = mid - 1;
            } else if (mid < num / mid) {
                low = mid + 1;
            } else {
                return mid * mid == num;  
            }
        }
        return false;
    }
}