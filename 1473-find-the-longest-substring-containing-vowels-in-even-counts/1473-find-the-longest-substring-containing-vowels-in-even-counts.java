class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<String, Integer> hash = new HashMap<>();

        int [] vowel = new int[5];

        String currState = "00000";
        hash.put(currState, -1);
        int res = 0;

        int i = 0;
        for (char ch: s.toCharArray()) {

            if (ch == 'a') {
                vowel[0] = vowel[0] ^ 1; 
            } else if (ch == 'e') {
                vowel[1] = vowel[1] ^ 1; 
            } else if (ch == 'i') {
                vowel[2] = vowel[2] ^ 1; 
            } else if (ch == 'o') {
                vowel[3] = vowel[3] ^ 1; 
            } else if (ch == 'u') {
                vowel[4] = vowel[4] ^ 1; 
            }

            currState = "";
            for (int num: vowel) {
                currState += num;
            }
            
            if (hash.containsKey(currState)) {
                res = Math.max(res, i - hash.get(currState));
            } else {
                hash.put(currState, i);
            }

            i++;

        }
        return res;
    }
}