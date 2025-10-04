class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : nums){
            if (num % 2 == 0)
                result[index++] = num;
        }

        for (int num : nums){
            if (num % 2 != 0)
                result[index++] = num;
        }
        return result;
    }
}