class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = Math.max(last[c], i);
        }

        int ans = 0;
        for (int c = 0; c < 26; c++) {
            if (first[c] < last[c]) {
                boolean[] seen = new boolean[26];
                for (int i = first[c] + 1; i < last[c]; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                }
                for (boolean b : seen) {
                    if (b) ans++;
                }
            }
        }
        return ans;
    }
}