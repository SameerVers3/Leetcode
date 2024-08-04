class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> arr = new ArrayList<>();
        final int MOD = 1_000_000_007; 
        
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                arr.add(sum);
            }
        }

        Collections.sort(arr);

        long result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + arr.get(i)) % MOD;
        }
        
        return (int) result;
    }
}