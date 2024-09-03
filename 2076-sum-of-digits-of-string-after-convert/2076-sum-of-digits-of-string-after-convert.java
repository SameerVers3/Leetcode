class Solution {
    public int getLucky(String s, int k) {
        int num = 0;
        for (char i: s.toCharArray()) {
            int val = i - 'a' + 1;

            while (val > 0) {
                num += val % 10;
                val /= 10;
            }
        }

        while ( k-- > 1){
            int sum = 0;
            while (num > 0) {
                sum += num % 10;; 
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}