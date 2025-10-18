class Solution {
    public long countSubstrings(String s, char c) {
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {  // ✅ fixed: compare to variable c, not 'c'
                count++;
            }
        }

        long result = count;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {  // ✅ fixed again
                count--;
                result += count;
            }
        }

        return result;
    }
}