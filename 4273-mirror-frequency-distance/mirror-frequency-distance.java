//import java.util.*;

class Solution {
    public int mirrorFrequency(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        
        // Step 1: Count frequencies
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        Set<Character> visited = new HashSet<>();
        int ans = 0;
        
        // Step 2: Process each character
        for (char c : freq.keySet()) {
            if (visited.contains(c)) continue;
            
            char m = mirror(c);
            
            int freqC = freq.getOrDefault(c, 0);
            int freqM = freq.getOrDefault(m, 0);
            
            ans += Math.abs(freqC - freqM);
            
            visited.add(c);
            visited.add(m);
        }
        
        return ans;
    }
    
    private char mirror(char c) {
        if (Character.isLetter(c)) {
            return (char) ('z' - (c - 'a'));
        } else {
            return (char) ('9' - (c - '0'));
        }
    }
}