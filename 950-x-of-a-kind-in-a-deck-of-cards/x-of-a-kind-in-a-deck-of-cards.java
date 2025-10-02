class Solution {
     public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int card : deck) {
            count[card]++;
        }

        int gcd = -1;
        for (int c : count) {
            if (c > 0) {
                if (gcd == -1) {
                    gcd = c;
                } else {
                    gcd = findGCD(gcd, c);
                }
            }
        }

        return gcd >= 2;
    }

    private int findGCD(int a, int b) {
        return (b == 0) ? a : findGCD(b, a % b);
    }
}