class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) max = num;
        }

        long result = 0;
        int left = 0, maxCount = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == max) maxCount++;

            while (maxCount >= k) {
                if (nums[left] == max) maxCount--;
                left++;
            }

            result += left;
        }

        return result;
    }
}