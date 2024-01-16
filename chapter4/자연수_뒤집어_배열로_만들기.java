class Solution {
    public int[] solution(long n) {
        String stringN = Long.toString(n);
        String reverseN = new StringBuilder(stringN).reverse().toString();
        int[] answer = new int[stringN.length()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = reverseN.charAt(i) - '0';
        }
        return answer;
    }
}