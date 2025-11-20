class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
         int n = nums.length;
        List<Integer> keyPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                keyPos.add(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        int p = 0;
        
        for (int i = 0; i < n; i++) {
            while (p < keyPos.size() && keyPos.get(p) < i - k) {
                p++;
            }
            
            if (p < keyPos.size() && Math.abs(keyPos.get(p) - i) <= k) {
                result.add(i);
            }
        }
        
        return result;
    }
}