class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width = 1, height = 1;
        int area = brown + yellow;
        while (true) {
            while (area % height != 0) {
                height++;
            }
            width = area / height;
            if (brown == (width  + height - 2) * 2) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
            height++;
        }
        return answer;
    }
}