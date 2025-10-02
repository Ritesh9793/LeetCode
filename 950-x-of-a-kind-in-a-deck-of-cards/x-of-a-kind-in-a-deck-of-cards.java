class Solution {
     public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int card : deck) count[card]++;
        
        int gcd = 0;
        for (int c : count) {
            if (c > 0) gcd = gcd == 0 ? c : gcd(gcd, c);
        }
        
        return gcd >= 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}