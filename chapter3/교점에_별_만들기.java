import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    private static class Point {
        public final long x, y;
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
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
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersectionP = intersection(line[i][0], line[i][1], line[i][2]
                                                , line[j][0], line[j][1], line[j][2]);
                if (intersectionP != null) {
                    points.add(intersectionP);
                }
            }
        }
        
        Point minP = getMinPoint(points);
        Point maxP = getMaxPoint(points);
        
        int width = (int) (maxP.x - minP.x + 1);
        int height = (int) (maxP.y - minP.y + 1);
        
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }
        
        for (Point p : points) {
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