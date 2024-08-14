class Solution {
    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);

        int [] pairCount = new int[(nums[nums.length - 1] - nums[0]) + 1];
                
        for (int i = 0 ; i < nums.length - 1 ; i++) {
            for (int j = i + 1 ; j < nums.length ; j++) {
                int dis = Math.abs(nums[i] - nums[j]);
                pairCount[dis]++;
            }
        }

        for (int i = 0 ; i < pairCount.length ; i++) {
            k -= pairCount[i];
            if ( k <= 0) {
                return i;
            }
        }

        return pairCount.length - 1;
    }
}