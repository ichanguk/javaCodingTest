import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answerList = new ArrayList<>();
        int[] score = new int[3];
        score[0] = solveOne(answers);
        score[1] = solveTwo(answers);
        score[2] = solveThree(answers);
        
        int max = 0;
        for (int s : score) {
            if (s > max) {
                max = s;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) {
                answerList.add(i + 1);
            }
        }
        
        int[] answer = answerList.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
        
        return answer;
    }
    public int solveOne(int[] answers) {
        int score = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == i % 5 + 1) {
                score++;
            }
        }
        return score;
    }
    
    public int solveTwo(int[] answers) {
        int score = 0;
        int[] menu = {1, 3, 4, 5};
        for (int i = 0; i < answers.length; i++) {
            if (i % 2 == 0) {
                if (answers[i] == 2) {
                    score++;
                }
            }
            else {
                if (answers[i] == menu[(i / 2) % 4]) {
                    score++;
                }
            }
        }
        return score;
    }
    
    public int solveThree(int[] answers) {
        int score = 0;
        int[] menu = {3, 1, 2, 4, 5};
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == menu[(i / 2) % 5]) {
                score++;
            }
        }
        return score;
    }
}