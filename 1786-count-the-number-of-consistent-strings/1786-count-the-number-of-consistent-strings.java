class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<Character>();
        for (char c: allowed.toCharArray()) {
            set.add(c);
        }

        boolean valid;
        int count = 0;
        for(String word: words){
            valid = true;
            for(char c: word.toCharArray()) {
                if (!set.contains(c)){
                    valid = false;
                    break;
                }
            }
            count += valid ? 1 : 0;
        }
        return count;
    }
}