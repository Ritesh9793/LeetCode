class TopVotedCandidate {

     private int[] times;
    private int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        int n = persons.length;

        leaders = new int[n];
        Map<Integer, Integer> count = new HashMap<>();
        
        int leader = -1, leaderVotes = 0;

        for (int i = 0; i < n; i++) {
            int p = persons[i];
            count.put(p, count.getOrDefault(p, 0) + 1);

            if (count.get(p) >= leaderVotes) {
                leader = p;
                leaderVotes = count.get(p);
            }

            leaders[i] = leader;
        }
    }

    public int q(int t) {
        int idx = Arrays.binarySearch(times, t);

        if (idx < 0) {
            idx = -idx - 2; 
        }
        
        return leaders[idx];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */