class Solution {
    int i = 0;
    int[][] answer;
    public int[][] solution(int n) {
        answer = new int[(int)(Math.pow(2, n)) - 1][2];
        hanoi(n, 1, 3);
        return answer;
    }
    public void hanoi(int n,int from, int to) {
        if (n == 1) {
            answer[i][0] = from;
            answer[i++][1] = to;
            return;
        }
        hanoi(n - 1, from, 6 - from - to);
        hanoi(1, from, to);
        hanoi(n - 1, 6 - from - to, to);
    }
}