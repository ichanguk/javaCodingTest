class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0;
        int cnt = 0;
        while (!s.equals("1")) {
            cnt++;
            String zeroDeleteS = s.replace("0", "");
            //0을 지우고 지워진 길이만큼 zeroCnt에 더해줌
            zeroCnt += s.length() - zeroDeleteS.length();
            s = Integer.toString(zeroDeleteS.length(), 2);
        }
        int[] answer = {cnt, zeroCnt};
        return answer;
    }
}