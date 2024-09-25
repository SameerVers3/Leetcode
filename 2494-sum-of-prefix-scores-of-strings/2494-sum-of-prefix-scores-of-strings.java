class Solution {
    
    class TrieNode {
        int prefixCount = 0; 
        TrieNode[] children = new TrieNode[26]; 

        public TrieNode() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            prefixCount = 0;
        }
    }

    private TrieNode createTrieNode() {
        return new TrieNode(); 
    }

    private void addWord(String word, TrieNode root) {
        TrieNode currentNode = root;
        
        for (char character : word.toCharArray()) {
            int index = character - 'a';
            
            if (currentNode.children[index] == null) {
                currentNode.children[index] = createTrieNode();
            }
            
            currentNode.children[index].prefixCount += 1;
            currentNode = currentNode.children[index];
        }
    }

    private int calculateScore(String word, TrieNode root) {
        TrieNode currentNode = root;
        int totalScore = 0;

        for (char character : word.toCharArray()) {
            int index = character - 'a';
            totalScore += currentNode.children[index].prefixCount;
            currentNode = currentNode.children[index];
        }

        return totalScore;
    }

    public int[] sumPrefixScores(String[] words) {
        int wordCount = words.length;
        TrieNode root = createTrieNode();

        for (String word : words) {
            addWord(word, root);
        }

        int[] scores = new int[wordCount];

        for (int i = 0; i < wordCount; i++) {
            scores[i] = calculateScore(words[i], root);
        }

        return scores;
    }
}
