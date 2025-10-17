class Solution {
    String s;
    int n;
    int K;

    Map<Long, Integer> memo;
    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s;
        this.n = s.length();
        this.K = k;
        memo = new HashMap<>();

        return dfs(0, 0, 0) + 1;
    }

    private int dfs(int i, int used, int mask) {
        if (i >= n) {
            return 0;  // no more characters → no further cuts
        }
        // pack state into a long key: (i << something) | (used << something) | mask
        long key = (((long)i) << 34) | (((long)used) << 33) | mask;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int best = 0;

        // Option 1: take s[i] as is
        int c = s.charAt(i) - 'a';
        int newMask = mask | (1 << c);
        if (Integer.bitCount(newMask) <= K) {
            // still valid in same partition
            best = Math.max(best, dfs(i + 1, used, newMask));
        } else {
            // would exceed K distinct → we must cut before this char, so this char starts a new partition
            // new partition: we “cut” one, and this char becomes first char of next partition
            best = Math.max(best, 1 + dfs(i + 1, used, (1 << c)));
        }

        // Option 2: if not used change yet, try changing s[i] to any other character
        if (used == 0) {
            for (int x = 0; x < 26; x++) {
                if (x == c) continue;
                int altMask = mask | (1 << x);
                if (Integer.bitCount(altMask) <= K) {
                    // we can change s[i] to char x and stay in this partition
                    best = Math.max(best, dfs(i + 1, 1, altMask));
                } else {
                    // changing to x would also overflow → we cut before this char, then x starts new
                    best = Math.max(best, 1 + dfs(i + 1, 1, (1 << x)));
                }
            }
        }

        memo.put(key, best);
        return best;
    }
}