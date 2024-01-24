import java.util.Arrays;
class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((s1, s2) -> Integer.parseInt(s2 + s1) -
                   Integer.parseInt(s1 + s2))
            .collect(StringBuilder::new,
                    StringBuilder::append,
                    StringBuilder::append)
            .toString()
            .replaceAll("^0+", "0");
    }
}