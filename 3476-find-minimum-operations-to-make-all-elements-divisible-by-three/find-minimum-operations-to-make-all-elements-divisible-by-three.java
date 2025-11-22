class Solution {
    public int minimumOperations(int[] nums) {
         int ops = 0;

        for (int x : nums) {
            // If x % 3 == 0 → already divisible, no operation needed
            // If x % 3 == 1 or 2 → we can always fix it in exactly 1 operation
            if (x % 3 != 0) {
                ops++;
            }
        }

        return ops;
    }
}