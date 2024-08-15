class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char str1 = s.charAt(i);     
            char str2 = t.charAt(i);

            if (!map.containsKey(str1)) {    
                if (!map.containsValue(str2)) {  
                    map.put(str1,str2);
                } else {
                    return false;
                }
            } else {
                if (map.get(str1) != str2) {
                    return false;
                }
            }
        }
        return true;
    }
}