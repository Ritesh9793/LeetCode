class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];
        // pq ka use karke values ko descending order me kar diya 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        //sabko pq me store kar diya
        for (int i = 0; i < score.length; i++) {
            pq.offer(new int[]{score[i], i});
        }
        
        int rank = 1;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int index = top[1];
            //rank assign kar diya 
            if (rank == 1) {
                result[index] = "Gold Medal";
            } else if (rank == 2) {
                result[index] = "Silver Medal";
            } else if (rank == 3) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(rank);
            }
            rank++;
        }

        return result;
    }
}