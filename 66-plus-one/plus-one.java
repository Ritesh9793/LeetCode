class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;   
                return digits; 
            }
            digits[i] = 0;    
        }
        
        // jab hamare paas sab digit 9 ho tab (jaise ki  999 -> 1000)
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}