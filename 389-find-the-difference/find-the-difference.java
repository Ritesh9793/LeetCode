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


        // //s aur t dono par XOR kar liya
        // for (int i = 0; i < s.length(); i++) {
        //     xor ^= s.charAt(i);
        //     xor ^= t.charAt(i);
        // }

        // // t ke last char ko XOR kar leta hu (kyoki t 1 char extra length ka hai)
        // xor ^= t.charAt(t.length() - 1);

        // return (char) xor;
    }
}