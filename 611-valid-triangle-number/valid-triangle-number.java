class Solution {
    public int triangleNumber(int[] nums) {
        //pehle sort kar diya
        Arrays.sort(nums);
        //aur phir 2 pointer approach use karke
        int n = nums.length;
        int count = 0;
        //loop ki help se triangle condition a+b>c satisfy karne wale pairs ko count kar liya
        for (int i = n - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        //ab countt return kar liya
        return count;
    }
}