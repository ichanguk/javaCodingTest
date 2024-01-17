class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        
        if (s.replace("p", "").length() != s.replace("y", "").length()) {
            answer = false;
        }
        
        return answer;
    }
}