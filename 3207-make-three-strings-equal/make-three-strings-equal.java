class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int n = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int commonLength = 0;
        
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
                commonLength++;
            } else {
                break;
            }
        }

        if (commonLength == 0) return -1;

        int operations = (s1.length() - commonLength) +
                         (s2.length() - commonLength) +
                         (s3.length() - commonLength);

        return operations;
    }
}