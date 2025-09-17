class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i <= nums.length-1; i++){
            //agar nums[i] zero nahi hai aur nums[j] zero hai to dono ko swap kar dunga
            if(nums[i] != 0 && nums[j]==0){
                nums[i] = nums[i] + nums[j];
                nums[j] = nums[i] - nums[j];
                nums[i] = nums[i] - nums[j];
            }
            //agar nums[j] zero nahi hai to agla element compare karlenge
            if(nums[j]!=0){
                j++;
            }
        }
    }
}