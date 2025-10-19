class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> mad = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        for(int i = 1; i < arr.length; i++){
            int Diff = arr[i] - arr[i-1];
            if(Diff == minDiff){
                mad.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return mad;
    }
}