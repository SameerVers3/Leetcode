class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i = 0 ; i < chalk.length ; i++) {
            sum += chalk[i];
        }

        long rem =  k%sum;

        for (int i = 0 ; i < chalk.length; i++) {
            if (rem < chalk[i]) {
                return i;
            }

            rem -= chalk[i];
        }

        return -1;
    }
}