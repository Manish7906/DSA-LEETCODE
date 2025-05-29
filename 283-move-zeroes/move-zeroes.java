class Solution {
    public void moveZeroes(int[] nums) {
        int[] tempArray = new int[nums.length];
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                tempArray[index]=nums[i];
                index++;
            }
        }
         for (int i = 0; i < nums.length; i++) {
            nums[i] = tempArray[i];
        }
    }
}