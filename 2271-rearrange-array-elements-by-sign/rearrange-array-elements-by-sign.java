class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] newArray = new int[nums.length];
        int posindex=0;
        int negindex=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                newArray[negindex]=nums[i];
                negindex+=2;
            }
            else{
                newArray[posindex]=nums[i];
                posindex+=2;
            }
        }
        return newArray;
    }
}