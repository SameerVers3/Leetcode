class Solution {
    public int minLength(String s) {
        boolean done = false;

        while (!done) {
            s = s.replace("AB", "").replace("CD", "");

            if (s.contains("AB") || s.contains("CD")) {
                done = false;
            } else {
                done = true;
            }
        }

        return s.length();
    }
}