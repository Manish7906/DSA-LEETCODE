class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        
        while (n > 1) {
            int[] newNums = new int[n - 1];
            
            for (int i = 0; i < n - 1; i++) {
                newNums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            
            nums = newNums; // move to next row
            n--;            // reduce size
        }
        
        return nums[0]; // last remaining element
    }
}
