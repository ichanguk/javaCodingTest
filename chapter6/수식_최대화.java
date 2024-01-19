import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.List;

class Solution {
    String[][] precedences = {
        "*+-".split(""),
        "*-+".split(""),
        "+*-".split(""),
        "+-*".split(""),
        "-+*".split(""),
        "-*+".split("")
    };
    
    public long solution(String expression) {
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        long answer = 0;
        for (String[] p : precedences) {
            long res = Math.abs(calculate(new ArrayList<>(tokens), p));
            if (res > answer) {
                answer = res;
            }
        }
        return answer;
    }
    
    public long calculate(long lhs, long rhs, String op) {
        return switch (op) {
                case "+" -> lhs + rhs;
                case "-" -> lhs - rhs;
                case "*" -> lhs * rhs;
                default -> 0;
        };
    }
    
    public long calculate(List<String> tokens, String[] precedence) {
        for (String op : precedence) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long lhs = Long.parseLong(tokens.get(i - 1));
                    long rhs = Long.parseLong(tokens.get(i + 1));
                    long res = calculate(lhs, rhs, op);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(res));
                    i -= 2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }
}