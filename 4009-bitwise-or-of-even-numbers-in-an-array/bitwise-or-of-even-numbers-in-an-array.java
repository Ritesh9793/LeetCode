class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int result = 0;
        boolean foundEven = false;
        for (int x : nums) {
            if (x % 2 == 0) {
                result |= x;
                foundEven = true;
            }
        }
        return foundEven ? result : 0;
    }
}