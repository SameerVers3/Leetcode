class Solution {
    public int minSwaps(int[] nums) {
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) count++;
        }

        int i = 0, j=0, oneCount = 0, maxOne = 0;
        if (nums[j] == 1) {
            oneCount++;
            maxOne++;
        }

        while (j <= nums.length * 2) {
            j++;
            if (nums[j % nums.length] == 1) {
                oneCount++;
            }
            if (j-i >= count) {
                i++;
                if (nums[(i-1) % nums.length] == 1) {
                    oneCount--;
                }
            }
            maxOne = Math.max(maxOne, oneCount);
        }
        return count - maxOne;
    }
}