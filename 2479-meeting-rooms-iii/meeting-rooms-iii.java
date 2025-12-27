class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) freeRooms.offer(i);

        PriorityQueue<long[]> busy = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        int[] count = new int[n];

        for (int[] m : meetings) {
            long start = m[0], end = m[1];

            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                freeRooms.offer((int) busy.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                count[room]++;
                busy.offer(new long[]{end, room});
            } else {
                long[] top = busy.poll();
                long newEnd = top[0] + (end - start);
                int room = (int) top[1];
                count[room]++;
                busy.offer(new long[]{newEnd, room});
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) ans = i;
        }
        return ans;
    }
}