import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<String, Integer> numMap = new HashMap<>();
    // map을 안쓰고 zero ~ nine까지 String[] 배열을 만든 후 replace를 사용해도 됨
    public int solution(String s) {
        int answer = 0;
        numMap.put("zero", 0);
        numMap.put("one", 1);
        numMap.put("two", 2);
        numMap.put("three", 3);
        numMap.put("four", 4);
        numMap.put("five", 5);
        numMap.put("six", 6);
        numMap.put("seven", 7);
        numMap.put("eight", 8);
        numMap.put("nine", 9);
        
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                answer = answer * 10 + charArray[i] - '0';
            }
            else {
                sb.append(charArray[i]);
                if (sb.length() >= 3 && numMap.containsKey(sb.toString())) {
                    answer = answer * 10 + numMap.get(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        return answer;
    }
}