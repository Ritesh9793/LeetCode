class Solution {
    public boolean isMonotonic(int[] nums) {
        // 2 variable le liya boolean type ka 
        boolean increasing = true;
        boolean decreasing = true;
        //loop laga diya check karne ke liye
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                increasing = false; //agar monotonically increasing nahi hai to false return hoga
            }
            if (nums[i] < nums[i + 1]) {
                decreasing = false; //agar monotonically decreasing nahi hai to false return hoga
            }
        }
        // monotonically increasing ya decreasing true hone pe true return hoga
        return increasing || decreasing;
    }
}