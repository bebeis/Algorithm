import java.io.*;
import java.util.*;

/**
 * 동호가 받을 수 있는 최대 컵라면 수
 * 문제 푸는데 1 소요
 * n <= 200000
 */

/*
 * 데드라인이 최소로 남은 문제 중에서 가장 컵라면을 많이 받을 수 있는 문제를 푸는게 최적이지 않을까?
 * -> 착각이었다...
 * 11 22 33 55 66
 * 33 55 66 푸는게 
 * 12 35 56
 * 12 35 66
 * 22 55 66
 * 111111 8 8 
 * 1 8
 * 8 8 
 * k번째 시간에는, k ~ n 숫자가 모두 올 수 있음
 * 그 중에서 가장 많이 컵라면을 주는 것을 선택
 * 
 * 데드라인이 전부 N이면 순서대로 풀면됨
 * 데드라인이 전부 1이면 컵라면 수가 가장 많은 걸로 선택
 * 데드라인이 전부 k이면 컵라면 수가 가장 많은 것 중에서 k개 선택
 * 데드라인이 1 ~ k 섞여 있으면? -> 컵라면 수 가장 많은 걸 고르고, 그 자리에 배치
 * 
 */

/**
 * (deadline, ramen) 쌍을 deadline 오름차순으로 정렬한다.
 * 작은 힙(최소 힙)에 “지금까지 선택한 라면 수”들을 담는다.
 * 각 과제를 순서대로 보며 힙에 ramen을 넣고, 힙 크기가 현재 과제의 deadline을 초과하면(= 그 날까지 처리할 수 있는 개수보다 많이 골랐으면) 힙에서 가장 작은 라면 수를 빼서 버린다.
 * 끝나면 힙에 남은 값들의 합이 최대 라면 수.
 */

public class Main {

    static int n;
    static List<Problem> problems = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            problems.add(new Problem(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
        }

        Collections.sort(problems, (p1, p2) -> p1.deadLine - p2.deadLine);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
    
        for (var problem : problems) {
            pq.add(problem.count);

            if (pq.size() > problem.deadLine) {
                pq.poll();
            }
        }

        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.print(result);
    }

    static class Problem {
        int deadLine;
        int count;

        public Problem(int d, int c) {
            deadLine = d;
            count = c;
        }
    }
}