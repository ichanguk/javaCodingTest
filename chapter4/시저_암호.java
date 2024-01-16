class Solution {
    public String solution(String s, int n) {
        char[] charArr = s.toCharArray();
        
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isUpperCase(charArr[i])) {
                charArr[i] += n;
                if (charArr[i] > 'Z') {
                    charArr[i] -= 'z' - 'a' + 1;
                }
            }
            else if (Character.isLowerCase(charArr[i])) {
                charArr[i] += n;
                if (charArr[i] > 'z') {
                    charArr[i] -= 'z' - 'a' + 1;
                }
            }
        }
        
        String answer = new String(charArr);
        return answer;
    }
}