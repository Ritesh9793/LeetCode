class Solution {
    public boolean isPowerOfTwo(int n) {
        // according to the constraints as the int uses 32 bit
        for (int i = 0; i < 31; i++) {
            if ((1 << i) == n) 
            return true;
        }
        return false;
    }
}