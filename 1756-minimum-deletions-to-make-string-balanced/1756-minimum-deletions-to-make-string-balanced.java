class Solution {
    public int minimumDeletions(String s) {
        int [] a = new int[s.length()];        

        int a_count = 0;

        for (int j = s.length() - 1; j >= 0 ; j--) {
            a[j] = a_count;

            if (s.charAt(j) == 'a') {
                a_count++;
            }
        }

        int b_count = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i<s.length(); i++) {
            min = Math.min(min, a[i] + b_count);
            if (s.charAt(i) == 'b' ) b_count++;
        }

        return min;
    }
}