class Solution {
    // 공백이 1개 이상일 수 있으므로 split 사용 불가
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = s.toCharArray();
        boolean evenIdx = true;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ' ') {
                evenIdx = true;
                sb.append(' ');
                continue;
            }
            if (evenIdx && Character.isLowerCase(charArr[i])) {
                charArr[i] -= 'a' - 'A';
            }
            else if (!evenIdx && Character.isUpperCase(charArr[i])) {
                charArr[i] += 'a' - 'A';
            }
            sb.append(charArr[i]);
            evenIdx = !evenIdx;
        }
    
        return sb.toString();
    }
}