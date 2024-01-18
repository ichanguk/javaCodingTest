import java.util.ArrayList;
import java.util.List;

class Solution {
    int idx = 0;
    char[] vowel = {'A', 'E', 'I', 'O' ,'U'};
    List<String> dict = new ArrayList<>();
    public int solution(String word) {
        addDict("");
        return dict.indexOf(word) + 1;
    }
    public void addDict(String word) {
        if (word.length() == 5) {
            return;
        }
        // a -> a + add(a) -> a + add(e) -> ...가지치기
        for (char c : vowel) {
            dict.add(word + c);
            addDict(word + c);
        }
    }
}