class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String str: arr) {
            if (map.containsKey(str)){
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }           

        int lastUnique = 0, uniqueMember = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            if (map.get(arr[i]) == 1) {
                lastUnique++;
                uniqueMember++;
            }
            if (uniqueMember == k) return arr[i];
        }
        return "";
    }
}