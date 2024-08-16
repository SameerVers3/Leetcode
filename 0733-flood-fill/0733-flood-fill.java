class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sColor = image[sr][sc];

        if (sColor == color) return image;
        boolean [][] vis = new boolean[image.length][image[0].length];

        DFS(image, vis, sr, sc, color, sColor);

        return image;
    }

    public void DFS(int [][] image,boolean [][] vis, int i, int j, int color,int startColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || vis[i][j] || image[i][j] != startColor) {
            return;
        }

        vis[i][j] = true;

        image[i][j] = color;

        // up
        DFS(image, vis, i-1, j, color, startColor);
        // right
        DFS(image, vis, i, j+1, color, startColor);
        // down
        DFS(image, vis, i+1, j, color, startColor);
        // left
        DFS(image, vis, i, j-1, color, startColor);
    }
}