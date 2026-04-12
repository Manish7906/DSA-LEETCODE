class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        char target = (char)(digit + '0');
        for (int num : nums) {
            String s = String.valueOf(num);
            for (char c : s.toCharArray()) {
                if (c == target) count++;
            }
        }
        return count;
    }
}