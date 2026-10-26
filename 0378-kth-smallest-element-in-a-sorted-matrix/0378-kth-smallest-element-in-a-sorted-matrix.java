class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], hi = matrix[n-1][n-1];
        while (low < hi) {
            int mid = low + (hi - low) / 2;
            int count = 0, j = n - 1;
            for (int i = 0; i < n; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += j + 1;
            }
            if (count < k) low = mid + 1;
            else hi = mid;
        }
        return low;
    }
}