class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //unique elements set1 me store kar lenge
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // nums2 me intersection ke liye check kar lenge
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Set ko int array me convert kar lenge
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }
        //us int array ko return kar lenge
        return result;
    }
}