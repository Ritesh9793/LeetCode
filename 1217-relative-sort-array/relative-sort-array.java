class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for (int num : arr1) {
            max = Math.max(max, num);
        }

        int[] count = new int[max + 1];
        for (int num : arr1) {
            count[num]++;
        }

        int idx = 0;
        for (int num : arr2) {
            while (count[num]-- > 0) {
                arr1[idx++] = num;
            }
        }

        for (int num = 0; num <= max; num++) {
            while (count[num]-- > 0) {
                arr1[idx++] = num;
            }
        }

        return arr1;
    }
}