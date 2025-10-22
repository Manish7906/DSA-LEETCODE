class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String s : sentences) {
            // Split sentence into words
            int words = s.split(" ").length;
            max = Math.max(max, words);
        }
        return max;
    }
}
