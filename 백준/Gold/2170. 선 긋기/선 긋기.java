import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Line> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            lines.add(new Line(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
        }

        Collections.sort(lines, (l1, l2) -> {
            if (l1.x == l2.x) return l2.y - l1.y;
            return l1.x - l2.x;
        });

        LineTracker tracker = new LineTracker(lines.get(0).x, lines.get(0).y);

        lines.stream().skip(1).forEach(line -> tracker.addLine(line));

        System.out.print(tracker.length);
    }

    static class Line {
        int x, y;
        public Line(int xx, int yy) {
            x = xx;
            y = yy;
        }
    }

    static class LineTracker {
        int bx, by;
        int length;

        LineTracker(int x, int y) {
            bx = x;
            by = y;
            length = y - x;
        }

        void addLine(Line line) {
            if (line.x >= by) {
                length += (line.y - line.x);
                bx = line.x;
                by = line.y;
            } else if (line.y > by) {
                length += (line.y - by);
                by = line.y;
            }
        }
    }
}
