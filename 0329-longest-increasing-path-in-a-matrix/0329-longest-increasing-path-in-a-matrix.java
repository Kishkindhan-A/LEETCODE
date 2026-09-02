class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int result = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] == 0) result = Math.max(dfs(i, j, dp, rows, cols, matrix), result);
            }
        }
        return result;
    }

    private int dfs(int i, int j, int[][] dp, int rows, int cols, int[][] matrix) {
        if (dp[i][j] != 0) return dp[i][j]; int result = 1;
        if (i + 1 < rows && matrix[i][j] < matrix[i + 1][j]) result = Math.max(1 + dfs(i + 1, j, dp, rows, cols, matrix), result);
        if (i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j]) result = Math.max(1 + dfs(i - 1, j, dp, rows, cols, matrix), result);
        if (j + 1 < cols && matrix[i][j] < matrix[i][j + 1]) result = Math.max(1 + dfs(i, j + 1, dp, rows, cols, matrix), result);
        if (j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]) result = Math.max(1 + dfs(i, j - 1, dp, rows, cols, matrix), result);
        dp[i][j] = result;
        return result;
    }
}