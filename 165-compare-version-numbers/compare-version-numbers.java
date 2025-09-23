class Solution {
    public int compareVersion(String version1, String version2) {
        //pehle '.' ke basis pe split kar liya aur String type array me store kar liya
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        //dono array me se jiska length max hoga usko 'n' variable me store kar liya
        int n = Math.max(v1.length, v2.length);
        //ab ek loop ki help se array ke sabhi elements ko compare kar liya
        for (int i = 0; i < n; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        
        return 0;
    }
}