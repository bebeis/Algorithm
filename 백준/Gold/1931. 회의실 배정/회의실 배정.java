import java.io.*;
import java.util.*;

/**
 * 입력
 * - 회의의 시작 시간과 종료 시간
 * 
 * 문제: 최대한 많은 요소를 겹치지 않게 배치
 * - 최대한 많은 요소를 배치하려면 일단 짧아야 함
 * - 시작점을 기준으로 삼으면, 더 늦게 시작하고 더 빨리 끝나는 얘가 있을 수 있음
 * - 종료 시점을 기준으로 가장 짧은걸 골라 나가자
 */
class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            pairs.add(new Pair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
        }
        
        Collections.sort(pairs, (p1, p2) -> {
            if (p1.end != p2.end) {
                return p1.end - p2.end;
            }
            return p1.start - p2.start;
        });

        int cnt = 0;
        int curTime = 0;
        for (var pair : pairs) {
            if (pair.start >= curTime) {
                cnt++;
                curTime = pair.end;
            }
        }
        System.out.print(cnt);
    }

    static class Pair {
        int start;
        int end;

        public Pair(int s, int e) {
            start = s;
            end = e;
        }
    }
}