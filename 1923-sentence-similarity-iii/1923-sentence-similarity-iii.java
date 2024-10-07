class Solution {
    public boolean areSentencesSimilar(String str1, String str2) {
        String [] s1 = str1.split(" ");
        String [] s2 = str2.split(" ");

        int start = 0;
        int end = s1.length - 1;
        int endS2 = s2.length - 1;

        if (s1.length > s2.length) {
            return areSentencesSimilar(str2, str1);
        }

        while ( start < s1.length && s1[start].equals(s2[start])) {
            start++;
        }

        while (end >= 0 && s1[end].equals(s2[endS2])) {
            end--;
            endS2--;
        }

        return end < start;
    }
}