import java.util.HashMap;

class Solution {
    public long dividePlayers(int[] skill) {
        int sum = 0;
        for (int s : skill) {
            sum += s;
        }
        
        int n = skill.length;
        if (sum % (n / 2) != 0) {
            return -1;
        }
        
        int tsum = sum / (n / 2);
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        long res = 0L;
        
        for (int s : skill) {
            int c = tsum - s;
            
            if (freqMap.getOrDefault(c, 0) > 0) {
                res += (long) s * c;
                freqMap.put(c, freqMap.get(c) - 1);
            } else {
                freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
            }
        }

        for (int c : freqMap.values()) {
            if (c != 0) {
                return -1;
            }
        }
        
        return res;
    }
}
