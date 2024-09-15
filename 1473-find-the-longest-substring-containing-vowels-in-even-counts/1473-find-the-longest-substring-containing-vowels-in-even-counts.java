class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        int mask = 0;
        hash.put(mask, -1);
        int res = 0;
        int i = 0;
        for (char ch: s.toCharArray()) {

            if (ch == 'a') {
                mask = mask ^ (1 << 0);
            } else if (ch == 'e') {
                mask = mask ^ (1 << 1);
            } else if (ch == 'i') {
                mask = mask ^ (1 << 2);
            } else if (ch == 'o') {
                mask = mask ^ (1 << 3);
            } else if (ch == 'u') {
                mask = mask ^ (1 << 4);
            }
            
            if (hash.containsKey(mask)) {
                res = Math.max(res, i - hash.get(mask));
            } else {
                hash.put(mask, i);
            }

            i++;

        }
        return res;
    }
}