class Solution {
    public int longestSubarray(int[] nums) {
        int max = nums[0];
        for(int num: nums) {
            if (num > max) {
                max = num;
            }
        }

        int count = 0;
        int maxOccur = 0;
        for(int num: nums) {
            if (num == max) {
                count++;
            } else {
                maxOccur = Math.max(maxOccur, count);
                count=0;
            }
        }
        return Math.max(maxOccur, count);
    }
}