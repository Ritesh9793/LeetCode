class Solution {
    public int findClosest(int x, int y, int z) {
        int distance_from_X = Math.abs(z-x);
        int distance_from_Y = Math.abs(z-y);
        
        if(distance_from_X < distance_from_Y){
            return 1;
        }
        if (distance_from_X > distance_from_Y){
            return 2;
        }
        return 0;
    }
}