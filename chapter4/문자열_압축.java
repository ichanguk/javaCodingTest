class Solution {
    public int solution(String s) {
        int answer = 1001;
        char[] charArr = s.toCharArray();
        for (int n = 1; n <= charArr.length; n++) {
            String token = s.substring(0, n); // 첫 토큰은 subString으로 만듦
            StringBuilder sb = new StringBuilder();
            StringBuilder answerString = new StringBuilder();
            int cnt = 1;
            for (int i = n; i < charArr.length; i++) {
                sb.append(charArr[i]);
                if (sb.length() == n) {
                    if (token.equals(sb.toString())) {
                        cnt++; // token과 sb가 같으면 cnt++
                    }
                    else {
                        if (cnt > 1) {
                            answerString.append(cnt);
                        }
                        answerString.append(token);
                        token = sb.toString(); // token과 sb가 다르면 token을 sb로 교체
                        cnt = 1;
                    }
                    sb = new StringBuilder();
                 }
            }
            if (cnt > 1) {
               answerString.append(cnt);
            }
            answerString.append(token);
            answerString.append(sb.toString());

            if (answerString.length() < answer) {
                answer = answerString.length();
            }
        }
        return answer;
    }
}