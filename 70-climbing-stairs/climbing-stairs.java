class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int pehla = 1; 
        int dusra = 2; 

        for (int i = 3; i <= n; i++) {
            int kshad = pehla + dusra; 
            pehla = dusra;
            dusra = kshad;
        }
        return dusra;
    }
}