class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        long ans = 0L;

        // collect zero positions
        java.util.ArrayList<Integer> zp = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) if (s.charAt(i) == '0') zp.add(i);
        int m = zp.size();

        // z = 0: count all-ones substrings
        long cur = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') cur++;
            else {
                ans += cur * (cur + 1) / 2;
                cur = 0;
            }
        }
        ans += cur * (cur + 1) / 2;
        if (m == 0) return (int) ans;

        // sentinel array Z: Z[0] = -1, Z[1..m] = zero positions, Z[m+1] = n
        int[] Z = new int[m + 2];
        Z[0] = -1;
        for (int i = 0; i < m; i++) Z[i + 1] = zp.get(i);
        Z[m + 1] = n;

        // enumerate z >= 1
        for (int z = 1; z <= m && z + z * z <= n; z++) {
            long T = (long) z * z + z - 1; // we will use s+T as minimal end index (0-based)
            // groups of z consecutive zeros: group start index j from 1..m-z+1 (1-based in Z)
            for (int j = 1; j <= m - z + 1; j++) {
                int s_min = Z[j - 1] + 1;        // earliest start index
                int s_max = Z[j];                // latest start index that still includes first zero
                int e_min = Z[j + z - 1];        // earliest end index that includes last zero
                int e_max = Z[j + z] - 1;        // latest possible end index

                if (s_min > s_max || e_min > e_max) continue;

                // For a start s, minimal required end is max(e_min, s + T).
                // s must also satisfy s + T <= e_max to have any valid end.
                int s_upper_by_e = (int) (e_max - T); // s must be <= this to allow s+T <= e_max
                if (s_upper_by_e < s_min) continue;   // no start possible

                int s_end_valid = Math.min(s_max, s_upper_by_e);
                // split s into two regions:
                // Region A: s <= e_min - T  --> then max(e_min, s+T) = e_min (constant), each s gets totalEnds
                // Region B: s >= e_min - T +1 and s <= s_end_valid --> then min end = s+T, count decreases by 1 per s

                int s_cut = (int) (e_min - T); // boundary where s+T == e_min
                int A_start = s_min;
                int A_end = Math.min(s_end_valid, s_cut);
                if (A_end >= A_start) {
                    long totalEnds = (long) e_max - e_min + 1;
                    long k1 = (long) (A_end - A_start + 1);
                    ans += k1 * totalEnds;
                }

                int B_start = Math.max(s_min, s_cut + 1);
                int B_end = s_end_valid;
                if (B_end >= B_start) {
                    // for s = B_start, count = e_max - (s+T) + 1 = e_max - T - s + 1
                    long first = (long) e_max - T - B_start + 1;
                    long last  = (long) e_max - T - B_end + 1;
                    long k2 = (long) (B_end - B_start + 1);
                    // sum of arithmetic sequence: k2*(first + last)/2
                    ans += k2 * (first + last) / 2;
                }
            }
        }

        return (int) ans;
    }
}