class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int i: rolls){
            sum += i;
        }

        int total = ((mean * (n+rolls.length)) - sum);

        if (total < n || total > 6*n) {
            return new int[] {};
        }

        int [] res = new int[n];
        int index = 0;
        while (total > 0) {
            int dice = Math.min(total - n + 1, 6);
            res[index++] = dice;
            total -= dice;
            n--;
        }
        return res;
    }
}