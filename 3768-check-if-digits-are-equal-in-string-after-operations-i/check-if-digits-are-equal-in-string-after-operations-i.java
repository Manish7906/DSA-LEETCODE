class Solution {
    public boolean hasSameDigits(String s) {
        while (s.length() > 1) {
            StringBuilder sb = new StringBuilder();

            // Build next-level string using (a + b) % 10
            for (int i = 0; i < s.length() - 1; i++) {
                int a = s.charAt(i) - '0';
                int b = s.charAt(i + 1) - '0';
                sb.append((a + b) % 10);
            }

            s = sb.toString();

            // Check only if length > 1
            if (s.length() > 1 && allSame(s)) {
                return true;
            }
        }

        return false;
    }

    private boolean allSame(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(0)) return false;
        }
        return true;
    }
}
