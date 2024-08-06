class Solution {
    public int minimumPushes(String word) {
        int [] arr = new int[26];
        for (int i = 0; i<word.length() ; i++) {
            arr[word.charAt(i) - 'a']++;
        }

        Arrays.sort(arr); 
        int click = 0;
        int j = 0;
        for (int i = 25;  i >= 0 && arr[i] != 0 ; i--) {
            int freq = arr[i];
            int press = j/8 + 1;
            click += (freq * press);
            j++;
        }
        return click;
    }

}