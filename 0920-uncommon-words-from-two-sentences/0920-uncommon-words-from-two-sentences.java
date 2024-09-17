class Solution {
    public String[] uncommonFromSentences(String str1, String str2) {
        String [] s1 = str1.trim().split("\\s+");
        String [] s2 = str2.trim().split("\\s+");

        for (String word: s1) {
            System.out.println(word);
        }

        HashSet<String> h1 = new HashSet<>();
        HashSet<String> h2 = new HashSet<>();

        HashSet<String> dup = new HashSet<>();
        
        for (String word: s1) {
            if (h1.contains(word)) {
                dup.add(word);
            }
            else {
                h1.add(word);
            }
        }

        for (String word: s2) {
            if (h2.contains(word)) {
                dup.add(word);
            }
            else {
                h2.add(word);
            }
        }

        ArrayList<String> arr = new ArrayList<String>();

        for (String word: s1) {
            if (!dup.contains(word) && !h2.contains(word) ) {
                arr.add(word);
            }
        }

        for (String word: s2) {
            if (!dup.contains(word) && !h1.contains(word) ) {
                arr.add(word);
            }
        }

        String[] res = new String[arr.size()];
        res = arr.toArray(res);
        return res;
    }
}