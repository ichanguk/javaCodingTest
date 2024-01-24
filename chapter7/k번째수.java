import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] arr : commands) {
            int[] copyArr = Arrays.copyOfRange(array, arr[0] - 1, arr[1]);
            Arrays.sort(copyArr);
            answer[idx++] = copyArr[arr[2] - 1];
        }
        return answer;
    }
}