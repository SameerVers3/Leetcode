class Solution {
    public int minimumPushes(String word) {
        Map<Integer, Integer> map = new HashMap<>();

        int index = 2;
        int click = 0;
        for (String ch: word.split("")) {
            if (index  > 9 ) index = 2;

            if (!map.containsKey(index)) {
                map.put(index, 1);
            }
            else {
                map.put(index, map.get(index) + 1);
            }
            click += map.get(index);

            index++;
        }

        return click;
    }
}