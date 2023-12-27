import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    // 점을 표현하기 위한 Point class
    private static class Point {        
        public final long x, y;
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    // 교점을 반환하는 함수
    private Point intersection(long A, long B, long E, long C, long D, long F) {
        long denominator = A * D - B * C;
        if (denominator == 0) {
            return null;
        }
        else {
            double x = (double) (B * F - E * D) / denominator;
            double y = (double) (E * C - A * F) / denominator;
            if (x % 1 == 0 && y % 1 == 0) {
                return new Point((long) x, (long) y);
            }
            return null;
        }
    }

    // answer 배열의 크기 조정을 위한 x, y 좌표의 최댓값, 최솟값 구하기
    private Point getMinPoint(List<Point> points) {
        long x = points.get(0).x;
        long y = points.get(0).y;
        
        for (Point p : points) {
            if (p.x < x) {
                x = p.x;
            }
            if (p.y < y) {
                y = p.y;
            }
        }
        return new Point(x, y);
    }
    private Point getMaxPoint(List<Point> points) {
        long x = points.get(0).x;
        long y = points.get(0).y;
        
        for (Point p : points) {
            if (p.x > x) {
                x = p.x;
            }
            if (p.y > y) {
                y = p.y;
            }
        }
        return new Point(x, y);
    }
    
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();    // 교점을 저장하기 위한 배열
        for (int i = 0; i < line.length; i++) {    // 모든 직선 쌍에 대해 교점 구함
            for (int j = i + 1; j < line.length; j++) {
                Point intersectionP = intersection(line[i][0], line[i][1], line[i][2]
                                                , line[j][0], line[j][1], line[j][2]);
                if (intersectionP != null) {
                    points.add(intersectionP);
                }
            }
        }
        
        Point minP = getMinPoint(points);    // 저장된 정수들에 대해 x, y 좌표의 최댓값, 최솟값 구하기
        Point maxP = getMaxPoint(points);
        
        int width = (int) (maxP.x - minP.x + 1);    // 2차원 배열의 크기 조정정
        int height = (int) (maxP.y - minP.y + 1);
        
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }
        
        for (Point p : points) {            // 별 표시
            int x = (int) (p.x - minP.x);
            int y = (int) (maxP.y - p.y);
            arr[y][x] = '*';
        }
        
        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(arr[i]);
        }
        
        return answer;
    }
    

}
