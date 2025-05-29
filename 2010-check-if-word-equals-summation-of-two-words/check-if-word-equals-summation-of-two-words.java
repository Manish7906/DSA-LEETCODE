class Solution {
    public int wordToInt(String word) {
        int num = 0;
        for (char ch : word.toCharArray()) {
            num = num * 10 + (ch - 'a'); 
        }
        return num;
    }
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return wordToInt(firstWord) + wordToInt(secondWord) == wordToInt(targetWord);
    }
}