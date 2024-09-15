class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for (int num: nums) {
            if (!hash.contains(num)) {
                hash.add(num);
            } else {
                return true;
            }
        }
        return false;
    }
}

