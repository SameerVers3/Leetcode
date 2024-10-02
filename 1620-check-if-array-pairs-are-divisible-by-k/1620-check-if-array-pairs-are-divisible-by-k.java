class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : arr) {
            int mod = ((x % k) + k) % k;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        for (int mod : map.keySet()) {
            int freq = map.get(mod);
            
            if (mod == 0) {
                if (freq % 2 != 0) return false;
            } else {
                int comp = k - mod;
                if (map.getOrDefault(comp, 0) != freq) return false;
            }
        }

        return true;
    }
}