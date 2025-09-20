class Router {

    private static class Packet {
        int source;
        int destination;
        int timestamp;
        Packet(int s, int d, int t) {
            this.source = s;
            this.destination = d;
            this.timestamp = t;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Packet)) return false;
            Packet p = (Packet) o;
            return source == p.source
                && destination == p.destination
                && timestamp == p.timestamp;
        }
        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }

    private final int memoryLimit;
    private Queue<Packet> queue; 
    private Set<Packet> uniqueSet; 
    private Map<Integer, List<Integer>> destToTimestamps; 
    private Map<Integer, Integer> destRemovedCount; 

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new LinkedList<>();
        this.uniqueSet = new HashSet<>();
        this.destToTimestamps = new HashMap<>();
        this.destRemovedCount = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet p = new Packet(source, destination, timestamp);
        if (uniqueSet.contains(p)) {
            return false;
        }
        if (queue.size() == memoryLimit) {
            forwardPacket();  
        }
        queue.offer(p);
        uniqueSet.add(p);
        destToTimestamps
            .computeIfAbsent(destination, k -> new ArrayList<>())
            .add(timestamp);
        destRemovedCount.putIfAbsent(destination, 0);
        return true;
    }

    public List<Integer> forwardPacket() {
        if (queue.isEmpty()) {
            return Collections.emptyList();
        }
        Packet oldest = queue.poll();
        uniqueSet.remove(oldest);
        int dst = oldest.destination;
        destRemovedCount.put(dst, destRemovedCount.getOrDefault(dst, 0) + 1);
        return Arrays.asList(oldest.source, oldest.destination, oldest.timestamp);
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> timestamps = destToTimestamps.get(destination);
        if (timestamps == null) return 0;
        int removed = destRemovedCount.getOrDefault(destination, 0);
        int left = firstGreaterEqual(timestamps, removed, startTime);
        int right = firstGreater(timestamps, removed, endTime);
        return right - left;
    }

    private int firstGreaterEqual(List<Integer> list, int startIdx, int target) {
        int lo = startIdx, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int firstGreater(List<Integer> list, int startIdx, int target) {
        int lo = startIdx, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */