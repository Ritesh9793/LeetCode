class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : deck) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        int gcd = -1;
        for (int count : countMap.values()) {
            if (gcd == -1) {
                gcd = count;
            } else {
                gcd = findGCD(gcd, count);
            }
        }

        return gcd >= 2;
    }

    private int findGCD(int a, int b) {
        return (b == 0) ? a : findGCD(b, a % b);
    }
}