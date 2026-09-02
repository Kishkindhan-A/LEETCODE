class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        /* 
        prefixSum[i][j] = sum of rectangle(
            TopLeft = (0, 0),
            BottomRight = (i, j)
        )
        */
        int[][] prefixSum = buildPrefixSum(matrix);
        int result = Integer.MIN_VALUE;

        // traverse all possible rectangles
        for (int row1 = 0; row1 < matrix.length; row1++) {
            for (int col1 = 0; col1 < matrix[0].length; col1++) {
                // row2 >= row1, col2 >= col1
                for (int row2 = row1; row2 < matrix.length; row2++) {
                    for (int col2 = col1; col2 < matrix[0].length; col2++) {
                        int sum = getSum(prefixSum, row1, col1, row2, col2);
                        if (sum <= k) result = Math.max(result, sum);
                    }
                }
            }
        }

        return result;
    }

    private int[][] buildPrefixSum(int[][] arr) { // O(n^2)
        int[][] sum = new int[arr.length][arr[0].length];
        
        // base case
        sum[0][0] = arr[0][0];
        for (int col = 1; col < arr[0].length; col++) { // all sum[0][col]
            sum[0][col] = sum[0][col - 1] + arr[0][col];
        }
        for (int row = 1; row < arr.length; row++) { // all sum[row][0]
            sum[row][0] = sum[row - 1][0] + arr[row][0];
        }

        // induction rule for prefixSum[][]
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                sum[i][j] = (
                    sum[i - 1][j] + sum[i][j - 1] 
                    - sum[i - 1][j - 1]
                    + arr[i][j]
                );
            }
        }

        return sum;
    }

    // return the sum of the rectangle(TopLeft = {row1, col1}, bottomRight = {row2, col2})
    private int getSum(
        int[][] prefixSum, 
        int r1, int c1, int r2, int c2
    ) {
        int sum = prefixSum[r2][c2];
        if (r1 - 1 >= 0) sum -= prefixSum[r1 - 1][c2];
        if (c1 - 1 >= 0) sum -= prefixSum[r2][c1 - 1];
        if (r1 >= 1 && c1 >= 1) sum += prefixSum[r1 - 1][c1 - 1];

        return sum;
    }
}