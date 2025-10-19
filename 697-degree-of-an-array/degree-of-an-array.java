class Solution {
    public int findShortestSubArray(int[] nums) {

        /*
        ginti = count
        pehla = first
        antim = last
         */
        Map<Integer, Integer> ginti = new HashMap<>();   
        Map<Integer, Integer> pehla = new HashMap<>();  
        Map<Integer, Integer> antim = new HashMap<>();   

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            ginti.put(num, ginti.getOrDefault(num, 0) + 1);
            if (!pehla.containsKey(num)) {
                pehla.put(num, i);
            }
            antim.put(num, i);
        }

        int degree = Collections.max(ginti.values());
        int minLength = nums.length;

        for (int num : ginti.keySet()) {
            if (ginti.get(num) == degree) {
                int length = antim.get(num) - pehla.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }
}