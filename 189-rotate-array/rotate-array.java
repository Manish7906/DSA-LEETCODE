class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        if (size == 0) return;
        k = k % size;
        int a = size - k;

        List<Integer> result = new ArrayList<>();

        for (int i = a; i < size; i++) {
            result.add(nums[i]);
        }
        for (int i = 0; i < a; i++) {
            result.add(nums[i]);
        }

        // Copy back into nums (in-place update)
        for (int i = 0; i < size; i++) {
            nums[i] = result.get(i);
        }
    }
}