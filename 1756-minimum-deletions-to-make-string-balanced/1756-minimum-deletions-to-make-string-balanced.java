class Solution {
    public int minimumDeletions(String s) {
        int [] b = new int[s.length()];
        int [] a = new int[s.length()];        

        int b_count = 0;
        int a_count = 0;

        for (int i = 0, j = s.length() - 1; i < s.length() ; i++, j--) {
            b[i] = b_count;
            a[j] = a_count;

            if (s.charAt(i) == 'b') {
                b_count++;
            }
            if (s.charAt(j) == 'a') {
                a_count++;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i<s.length(); i++) {
            min = Math.min(min, a[i] + b[i]);
        }

        return min;
    }
}