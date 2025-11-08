class Solution {
    public int divide(int dividend, int divisor) {
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);

        int result = 0;

        while (dividendLong >= divisorLong) {
            long temp = divisorLong;
            long multiple = 1;

            while (dividendLong >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dividendLong -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }
}