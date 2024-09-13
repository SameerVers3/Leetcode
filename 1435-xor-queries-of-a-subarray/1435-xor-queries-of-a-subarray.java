class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // if (arr.length == 1){
        //     return arr;
        // }
        int [] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i=1; i<prefix.length; i++) {
            prefix[i] = prefix[i-1] ^ arr[i]; 
        }

        ArrayList<Integer> array = new ArrayList<>();
        for (int []q: queries) {
            int l = q[0];
            int r = q[1];
            array.add(prefix[r] ^ (l == 0 ? 0 : prefix[l-1]));
        }
        int[] ar = new int[array.size()];
        for (int i = 0 ; i < ar.length ; i++) {
            ar[i] = array.get(i);
        }

        return ar;
    }
}