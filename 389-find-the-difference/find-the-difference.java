class Solution {
    public char findTheDifference(String s, String t) {
        int xor = 0;
        
        // s ke sabhi char me XOR kar liya 
        for (char c : s.toCharArray()) {
            xor ^= c;
        }
        
        // Ab t ke sabhi char me XOR kar liya 
        for (char c : t.toCharArray()) {
            xor ^= c;
        }
        
        // dono char ke difference ko char me explicit conversion ki help se return kara liya
        return (char) xor;
    }
}