class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String newStr = s.concat(s);
        newStr = newStr.substring(1, newStr.length() - 1);
        System.out.println(newStr);

        if (newStr.indexOf(s) == -1) {
            return false; 
        }
        return true;
    }
}