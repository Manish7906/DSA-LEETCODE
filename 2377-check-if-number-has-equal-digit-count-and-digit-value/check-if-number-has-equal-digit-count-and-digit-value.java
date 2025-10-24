class Solution {
    public boolean digitCount(String num) {
        int n = num.length();
        int[] count = new int[10]; // count digits 0-9
        
        // Count frequency of each digit
        for (char ch : num.toCharArray()) {
            count[ch - '0']++;
        }
        
        // Check each index
        for (int i = 0; i < n; i++) {
            int expected = num.charAt(i) - '0';
            if (count[i] != expected) {
                return false; // mismatch found
            }
        }
        
        return true; // all match
    }
}
