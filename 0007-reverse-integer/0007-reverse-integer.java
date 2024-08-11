class Solution {
    public int reverse(int x) {
        int num = 0;

        String str =  Integer.toString(x);
        str = str.replace("-","");
        String rev  = "";
        for (int i = str.length() - 1 ; i >= 0 ; i--) {
            rev += str.charAt(i);
        }

        long reversed = Long.parseLong(rev);

        reversed = x < 0 ? reversed * -1 : reversed; 

        if (reversed < Math.pow(2, 31) * -1 || reversed > Math.pow(2, 31) - 1) {
            return 0;
        }
        return (int)reversed;
    }
}