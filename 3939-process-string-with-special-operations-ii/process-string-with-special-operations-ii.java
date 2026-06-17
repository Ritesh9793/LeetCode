class Solution {
    public char processStr(String s, long k) {
        long len = 0;

        // Calculate final length
        for (char c : s.toCharArray()) {
            if (c == '*') {
                len = Math.max(0, len - 1);
            } else if (c == '#') {
                len <<= 1;
            } else if (c == '%') {
                // length unchanged
            } else {
                len++;
            }
        }

        if (k >= len) {
            return '.';
        }

        // Reverse process
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '*') {
                // Before deletion length was len + 1
                len++;
            } 
            else if (c == '#') {
                long half = len / 2;

                if (k >= half) {
                    k -= half;
                }

                len = half;
            } 
            else if (c == '%') {
                k = len - 1 - k;
            } 
            else {
                len--;

                if (k == len) {
                    return c;
                }
            }
        }

        return '.';
    }
}