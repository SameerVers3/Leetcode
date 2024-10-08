class Solution {
    public int minSwaps(String s) {
        int o = 0;
        int c = 0;

        String [] str = s.split("");
        int count = 0;

        for(int i = 0 ; i < s.length() ; i++) {

            if (str[i].equals("[")) {
                o++;
            } else {
                c++;
            }

            if (c > o) {
                count++;
                o++;
                c--;
            }
        }
        return count;
    }
}