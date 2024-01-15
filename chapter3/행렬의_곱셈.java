class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int M, N;
        M = arr1.length;
        N = arr2[0].length;
        int[][] answer = new int[M][N];
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}