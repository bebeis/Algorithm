import java.util.*;
import java.util.stream.*;
// 소요 시간 짧은 것, 요청 시각 빠른 것, 번호 작은 순


class Solution {
    public int solution(int[][] jobs) {
        List<List<Integer>> durations = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            durations.add(new ArrayList<>());
        }
        for (int[] job : jobs) {
            durations.get(job[0]).add(job[1]);
        }
        
        PriorityQueue<Task> pq = new PriorityQueue<>();
        int sum = 0;
        boolean working = false;
        int requestTime = 0;
        int endTime = 0;
        
        for (int i = 0; i <= 500001; i++) {
            if (i <= 1000) {
                for (int duration : durations.get(i)) {
                    pq.offer(new Task(i, duration));
                }
            }
            
            if (working && i < endTime) continue;
            
            if (working && i == endTime) {
                working = false;
                sum += (endTime - requestTime);
            }
            
            if (!pq.isEmpty()) {
                Task cur = pq.poll();
                requestTime = cur.requestAt;
                endTime = i + cur.duration;
                working = true;
            }
        }
        
        return sum / jobs.length;
        
    }
}

class Task implements Comparable<Task> {
    
    int requestAt;
    int duration;
    
    public Task(int r, int d) {
        requestAt = r;
        duration = d;
    }
    
    @Override
    public int compareTo(Task t) {
        if (this.duration != t.duration) {
            return this.duration - t.duration;
        } else {
            return this.requestAt - t.requestAt;
        }
    }
}