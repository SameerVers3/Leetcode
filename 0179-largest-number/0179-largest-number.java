class Solution {
    public String largestNumber(int[] nums) {
        String []n = new String[nums.length];

        for (int i = 0 ; i < nums.length; i++) {
            n[i] = nums[i] + "";
        }

        Arrays.sort(n, (s1, s2) -> {
            return (s2 + s1).compareTo(s1 + s2);
        });

        if (n[0].equals("0")) {
            return "0";
        }

        String res = "";
        for(String str: n) {
            res += str;
        }
        return res;
    }
}