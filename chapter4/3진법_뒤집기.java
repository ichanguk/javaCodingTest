class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toString(n, 3);
        String reverseS = new StringBuilder(s).reverse().toString();
        answer = Integer.parseInt(reverseS, 3);
        return answer;
    }
}