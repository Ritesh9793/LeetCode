class Solution {
    public int reverse(int x) {
        int reversed_number = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            // this is to check whether the number overflows the limit 
            if(reversed_number > Integer.MAX_VALUE / 10 || (reversed_number == Integer.MAX_VALUE / 10 && digit > 7)){
                return 0;
            }
            // this is to check whether the number underfflows the limit ---
            if (reversed_number < Integer.MIN_VALUE / 10 || (reversed_number == Integer.MIN_VALUE / 10 && digit < -8)){
                return 0;
            }

            //again we assemble the number in reverse order ---
            reversed_number = reversed_number * 10 + digit;
        }

        return reversed_number;
    }
}