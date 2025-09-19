class Solution {
    public boolean isPalindrome(int x) {
        
        if (x < 0) return false;

        int[] nums = String.valueOf(x).chars().map(c -> c - '0').toArray();
        int n = nums.length;

        for (int i = 0; i < n / 2; i++) {
            if (nums[i] != nums[n - 1 - i]) {
                return false;
            }
        }
        return true;
    }
} 