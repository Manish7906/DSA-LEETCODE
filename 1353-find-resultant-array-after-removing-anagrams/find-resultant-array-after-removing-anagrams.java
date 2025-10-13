class Solution {
    public static List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                result.add(words[i]);
            } else {
                if (!isAnagram(words[i], words[i - 1])) {
                    result.add(words[i]);
                }
            }
        }
        return result;
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] count = new int[26];
        for (char c : s1.toCharArray()) count[c - 'a']++;
        for (char c : s2.toCharArray()) count[c - 'a']--;
        for (int val : count) if (val != 0) return false;
        return true;
    }
}