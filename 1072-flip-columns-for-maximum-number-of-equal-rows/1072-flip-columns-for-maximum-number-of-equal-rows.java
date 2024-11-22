class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int ret = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] flipped = new int[n];
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                 flipped[j] = 1 - matrix[i][j];
            }
            for (int j = 0; j < m; j++) {
                if (Arrays.equals(matrix[i], matrix[j]) || Arrays.equals(matrix[j], flipped)) {
                    count++;
                }
            }
            ret = Math.max(ret, count);
        }
        
        return ret;
    }
}