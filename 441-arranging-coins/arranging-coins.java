class Solution {
    public int arrangeCoins(int n) {
        //jaisa ki constraints diya gaya hai -> isliye long choose kar liya
        long left = 0, right = n;
        //jab tak condition satisfied hai tab tak while loop chalega
        while (left <= right) {
            //yaha madhya ko calculate kar liya
            long mid = left + (right - left) / 2;
            //aur uske according coins ko bhi calculate kar liya
            long coins = mid * (mid + 1) / 2;
            
            if (coins == n) {
                return (int) mid;
            }
            if (coins < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) right;
    }
}