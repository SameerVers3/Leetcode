class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int i = 0;
        int j = skill.length - 1;

        int sum = skill[i] + skill[j];

        long res = 0L;

        while (i < j) {
            int k = skill[i] + skill[j];
            if (k != sum) {
                return -1;
            }

            res += (long) (skill[i] * skill[j]);
            i++;
            j--;
        }

        return res;
    }
}