class Solution {
    public int minAddToMakeValid(String s) {
        int c = 0;
        int o = 0;

        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                o++;
            } else if (o > 0) {
                o--;
            } else {
                c++;
            }
        }

        return o+c;
    }
}