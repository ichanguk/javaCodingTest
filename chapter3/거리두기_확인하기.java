class Solution {
    private static final int dx[] = {-1, 0, 1, 0};
    private static final int dy[] = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = {1, 1, 1, 1, 1};
        for (int i = 0; i < 5; i++) {
            char[][] room = new char[5][5];
            for (int j = 0; j < 5; j++) {
                room[j] = places[i][j].toCharArray();
            }
            // String[][]를 char[][]로 변경

            for (int x = 0; x < 5; x++) {
                if (answer[i] == 0) {
                    break;
                }
                for (int y = 0; y < 5; y++) {
                    if (room[x][y] == 'P') {
                        if (!isCorrect(room, x, y)) {
                            answer[i] = 0;
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
    
    public boolean isCorrect(char[][] room, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                // 거리가 1인 경우
                if (room[nx][ny] == 'P') {
                    return false;
                }
                // 거리가 2인 경우
                if (room[nx][ny] == 'O') {
                    for (int j = 0; j < 4; j++) {
                        int nnx = nx + dx[j];
                        int nny = ny + dy[j];
                        if (nnx == x && nny == y) {
                            continue;
                        }
                        if (nnx >= 0 && nnx < 5 && nny >= 0 && nny < 5) {
                            if (room[nnx][nny] == 'P') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}