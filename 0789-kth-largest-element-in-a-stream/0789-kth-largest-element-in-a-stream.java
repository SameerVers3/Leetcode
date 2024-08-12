class KthLargest {

    public int k;
    public ArrayList<Integer> nums = new ArrayList<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0 ; i< nums.length ; i++) {
            this.nums.add(nums[i]);
        }
    }
    
    public int add(int val) {
        this.nums.add(val);
        Collections.sort(nums, Collections.reverseOrder());
        return nums.get(k-1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */