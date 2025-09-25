class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        // last se dusre row se shuru karte huwe upar ki or iterate karenge
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> currentRow = triangle.get(i);
            List<Integer> nextRow = triangle.get(i + 1);
            
            for (int j = 0; j < currentRow.size(); j++) {
                int minPath = Math.min(nextRow.get(j), nextRow.get(j + 1));
                currentRow.set(j, currentRow.get(j) + minPath);
            }
        }
        
        // ab sabse upar ka element minimum path sum return kara denge
        return triangle.get(0).get(0);
    }
}