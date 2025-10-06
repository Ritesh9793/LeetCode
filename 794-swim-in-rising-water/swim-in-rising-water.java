class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[n][n];
        
        // Min-heap: stores {elevation, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        int result = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int elevation = curr[0];
            int r = curr[1], c = curr[2];
            
            // Update the maximum elevation we have seen
            result = Math.max(result, elevation);
            
            // If we reach the destination
            if (r == n-1 && c == n-1)
                return result;
            
            // Skip visited cells
            if (visited[r][c]) continue;
            visited[r][c] = true;
            
            // Explore neighbors
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    pq.offer(new int[]{grid[nr][nc], nr, nc});
                }
            }
        }
        
        return -1; // should never reach here
    }
}