class Solution {
    public int[] solution(int n) {
        int endI = n * (n + 1) / 2;
        int[] answer = new int[endI];
        int[][] triangle = new int[n][n];
        int i = 1;
        int x = 0, y = 0;
        
        while (true) {
            // 아래로 이동
            while (true) {
                triangle[x][y] = i++;
                if (x + 1 >= n || triangle[x + 1][y] != 0) {
                    break;
                }
                x++;
            }
            
            if (i > endI) {
                break;
            }
            y++;

            // 오른쪽으로 이동
            while (true) {
                triangle[x][y] = i++;
                if (y + 1 >= n || triangle[x][y + 1] != 0) {
                    break;
                }
                y++;
            }
            if (i > endI) {
                break;
            }
            x--;
            y--;
            
            // 대각선 위로 이동
            while (true) {
                triangle[x][y] = i++;
                if (triangle[x - 1][y - 1] != 0) {
                    break;
                }
                x--;
                y--;
            }
            if (i > endI) {
                break;
            }
            x++;
        }
        
        int idx = 0;
        for (x = 0; x < n; x++) {
            for (y = 0; y < x + 1; y++) {
                answer[idx++] = triangle[x][y];
            }
        }
        
        return answer;
    }
}