class Solution {
    public int minimumDeletions(String s) {       
        int a_count = 0;
        int b_count = 0;

        for (int i = 0 ; i< s.length() ; i++) {
            if (s.charAt(i) == 'a') a_count++;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == 'a') --a_count;
            min = Math.min(min, (a_count) + b_count);            
            if (s.charAt(i) == 'b' ) b_count++;
        }

        return min;
    }
}