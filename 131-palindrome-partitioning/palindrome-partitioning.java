class Solution {
    int n;
    
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    
    private void backtrack(String s, int idx, List<String> curr, List<List<String>> result) {
        if (idx == n) {
            result.add(new ArrayList<>(curr)); // copy current partition
            return;
        }
        
        for (int i = idx; i < n; i++) {
            if (isPalindrome(s, idx, i)) {
                curr.add(s.substring(idx, i + 1)); // take substring s[idx..i]
                backtrack(s, i + 1, curr, result);
                curr.remove(curr.size() - 1); // backtrack
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        n = s.length();
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
}
/*[]  
backtrack("aab", 0, [], result)
│
├─ i=0, substring="a" (palindrome)
│   └─ backtrack("aab", 1, ["a"], result)
│       │
│       ├─ i=1, substring="a" (palindrome)
│       │   └─ backtrack("aab", 2, ["a","a"], result)
│       │       │
│       │       ├─ i=2, substring="b" (palindrome)
│       │       │   └─ backtrack("aab", 3, ["a","a","b"], result)
│       │       │       └─ idx==n → add ["a","a","b"]
│       │       │
│       │       └─ end loop
│       │
│       ├─ i=2, substring="ab" (NOT palindrome) → skip
│       │
│       └─ end loop
│
├─ i=1, substring="aa" (palindrome)
│   └─ backtrack("aab", 2, ["aa"], result)
│       │
│       ├─ i=2, substring="b" (palindrome)
│       │   └─ backtrack("aab", 3, ["aa","b"], result)
│       │       └─ idx==n → add ["aa","b"]
│       │
│       └─ end loop
│
├─ i=2, substring="aab" (NOT palindrome) → skip
│
└─ end loop

 */
