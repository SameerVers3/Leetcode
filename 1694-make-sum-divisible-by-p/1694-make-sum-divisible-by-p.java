import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int num: nums) {
            sum += num;
        }

        int k = (int)(sum % p);
        if (k == 0) {
            return 0;
        }

        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1);

        long prefixSum = 0;
        int res = nums.length;

        for (int j = 0; j < nums.length; j++) {
            prefixSum += nums[j];
            int mod = (int)(prefixSum % p);

            int targetMod = (mod - k + p) % p;

            if (modMap.containsKey(targetMod)) {
                res = Math.min(res, j - modMap.get(targetMod));
            }

            modMap.put(mod, j);
        }

        return res == nums.length ? -1 : res;
    }
}
