class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] sortedArr = new int[nums.length];
        //recursion concept to operate on every element of nums array
        for(int num = 0; num < nums.length; num++){
            sortedArr[num] = nums[num]*nums[num];
        }
        //sort them using Arrays collection
        Arrays.sort(sortedArr);
        //return the sorted array
        return sortedArr;
    }
}