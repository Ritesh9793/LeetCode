class Solution {
    public int getLeastFrequentDigit(int n) {
        //`n` ke sabhi digits ko list me add kar lenge
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        
        // ab integer array me convert kar lenge
        int[] digits = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            digits[i] = list.get(i);
        }
        
        // Sorting karne ke baad
        Arrays.sort(digits);
        
        // two pointer approach use karenge
        int minCount = Integer.MAX_VALUE;
        int result = -1;
        int i = 0;
        while (i < digits.length) {
            int j = i;
            while (j < digits.length && digits[j] == digits[i]) {
                j++;
            }
            int freq = j - i;
            int digit = digits[i];
            
            if (freq < minCount || (freq == minCount && digit < result)) {
                minCount = freq;
                result = digit;
            }
            i = j;
        }
        
        return result;
    }
}