class Solution {
    int[] answer = {0, 0};
    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }
    public void compress(int[][] arr, int x, int y, int size) {
        boolean hasZero = false, hasOne = false;
        // (x,y)에서 시작해서 size X size만큼의 영역이 압축 가능한지 체크
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] == 1) {
                    hasOne = true;
                }
                else {
                    hasZero = true;
                }
            }
        }
        if (!hasZero) {
            // 0이 없으면 1로 압축 가능
            answer[1]++;
        }
        else if (!hasOne) {
            // 1이 없으면 0으로 압축 가능
            answer[0]++;
        }
        else {
            // 아니면 다시 영역을 쪼갬
            compress(arr, x, y, size / 2);
            compress(arr, x + size / 2, y, size / 2);
            compress(arr, x, y + size / 2, size / 2);
            compress(arr, x + size / 2, y + size / 2, size / 2);
        }
    }
}