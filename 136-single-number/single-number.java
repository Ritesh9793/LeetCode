class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            //XOR operation hi kehnde bhai ko
            result ^= num; 
        }
        return result;
    }
}