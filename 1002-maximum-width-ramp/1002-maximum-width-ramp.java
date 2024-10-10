class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] maxArr = new int[n];
        int max = nums[n-1];
        for (int i = n-1 ; i >= 0 ; i--) {
            if (nums[i] > max) {
                max = nums[i];
            }
            maxArr[i] = max;
        }

        int maxRamp = 0;

        int i = 0;
        int j = 0;

        while (j < n) {

            while (i < j && nums[i] > maxArr[j]) {
                i++;
            }

            maxRamp = Math.max(maxRamp, j-i);
            j++;
        }
    return maxRamp;
    }
}