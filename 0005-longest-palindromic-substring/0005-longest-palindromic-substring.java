class Solution {
    public String longestPalindrome(String s) {

        int lStart = 0, lEnd = 0;

        for (int i = 0; i<s.length() ; i++) {
            int len1 = isPalindrom(s, i, i);
            int len2 = isPalindrom(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > lEnd - lStart) {
                lStart = i - (len - 1) / 2;
                lEnd = i + len / 2;
            }
        }
        return s.substring(lStart, lEnd + 1);
    }

    public int isPalindrom(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}