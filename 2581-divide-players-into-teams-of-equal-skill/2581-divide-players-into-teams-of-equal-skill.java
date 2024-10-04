class Solution {
    public long dividePlayers(int[] skill) {
        int totalSum = Arrays.stream(skill).sum();
        if (totalSum % (skill.length / 2) != 0) {
            return -1;
        }


        Arrays.sort(skill);

        int i = 0;
        int j = skill.length - 1;

        int sum = skill[i] + skill[j];

        long res = 0L;

        while (i < j) {
            if (skill[i] + skill[j] != sum) {
                return -1;
            }

            res += (long) (skill[i] * skill[j]);
            i++;
            j--;
        }

        return res;
    }
}