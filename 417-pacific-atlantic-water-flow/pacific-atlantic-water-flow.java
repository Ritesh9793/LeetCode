class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;

        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            pacificQueue.offer(new int[]{i, 0});
            atlanticQueue.offer(new int[]{i, n - 1});
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pacificQueue.offer(new int[]{0, j});
            atlanticQueue.offer(new int[]{m - 1, j});
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;
        }

        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        int m = heights.length, n = heights[0].length;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : DIRECTIONS) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) continue;
                if (heights[nx][ny] < heights[x][y]) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

}