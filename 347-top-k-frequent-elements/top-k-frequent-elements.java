class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // Step 2: Convert to list of unique elements
        List<Integer> elements = new ArrayList<>(freqMap.keySet());
        // Step 3: Sort elements by frequency (descending)
        Collections.sort(elements, (a, b) -> freqMap.get(b) - freqMap.get(a));
        // Step 4: Pick first k elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = elements.get(i);
        }
        return result;
    }
}
