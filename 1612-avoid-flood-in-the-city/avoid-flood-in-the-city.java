class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        Map<Integer, Integer> lakeLastRain = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                dryDays.add(i);
                result[i] = 1; 
            } else {
                result[i] = -1; 
                if (lakeLastRain.containsKey(lake)) {
                    int lastRainDay = lakeLastRain.get(lake);
                    Integer dryDay = dryDays.higher(lastRainDay);
                    if (dryDay == null) {
                        
                        return new int[0];
                    }
                    result[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                lakeLastRain.put(lake, i);
            }
        }
        return result;
    }
}