class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        //kaun sa number kitni baar hai usko count kar liya
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        //kiski jyada sankhya hai wo pata kar liya
        int maxFreq = 0;
        for (int freq : freqMap.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        //ab jyyada count wale number ki sankhya calculate kar liya
        int result = 0;
        for (int freq : freqMap.values()) {
            if (freq == maxFreq) {
                result += freq;
            }
        }

        return result;
    }
}