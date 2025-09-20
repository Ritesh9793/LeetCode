class Solution {
    public int lengthOfLastWord(String s) {
        int samkhya = 0;
        // space ki madad se array me store kar lunga
        String[] arr = s.split(" ");
        
        // aakhiri shabd le leta hu
        String last = arr[arr.length - 1];
        
        // ab iska length calculate kar leta hu
        samkhya = last.length();
        //length return kara diya
        return samkhya;
    }
}