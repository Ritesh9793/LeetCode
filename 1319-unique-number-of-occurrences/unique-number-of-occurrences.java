class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // frequency count kar lenge
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // frequency unique hai ya nahi 
        Set<Integer> occurrences = new HashSet<>();
        for (int freq : countMap.values()) {
            if (!occurrences.add(freq)) {
                //agar freuency dublicate hui to 
                return false;
            }
        }

        return true;
    }
}