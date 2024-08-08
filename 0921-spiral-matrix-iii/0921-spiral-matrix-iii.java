class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int width = 1;
        int [][] list = new int[rows*cols][2];
        int direction = 0;
        int index=0;

        while (index < rows * cols) {
            for (int i = 0 ; i < width ; i++) {
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    list[index][0] = rStart;
                    list[index][1] = cStart;
                    index++;
                }

                switch (direction) {
                    case 0: cStart++; break;
                    case 1: rStart++; break;
                    case 2: cStart--; break;
                    case 3: rStart--; break;
                }
            }

            direction = (direction + 1) % 4;

            if  (direction % 2 == 0) {
                width++;
            }
        }
        return list;
    }
}