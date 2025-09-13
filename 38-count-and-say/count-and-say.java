class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String current = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;

            for (int j = 1; j < current.length(); j++) {
                
                if (current.charAt(j) == current.charAt(j - 1)) {
                    count++;
                    
                } else {
                    next.append(count).append(current.charAt(j - 1));
                    count = 1;
                }
            }

            next.append(count).append(current.charAt(current.length() - 1));
            current = next.toString();
        }

        return current;
    }
}