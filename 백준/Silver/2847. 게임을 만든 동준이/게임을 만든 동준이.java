import java.io.*;

/**
 * 실수로 쉬운 레벨이 어려운 레벨보다 점수를 많이 받는 경우 존재
 * 특정 레벨의 점수를 감소하게 만든다.
 * 최소한의 점수 내리기로 문제 해결
 * 
 * 마지막 단계부터 시작해서, n - 1 단계 점수가 n단계보다 작으면 pass, n단계보다 크면 (scores[n] - 1)로 설정
 */

public class Main {

    static int n;
    static int[] scores = new int[102];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int front = n - 2; front >= 0; front--) {
            int rear = front + 1;
            if (scores[front] < scores[rear]) continue;
            /**
             * scores[rear] - scores[front] = 1
             * scores[front] = scores[rear] - 1 이 되야 함
             * count = scores[front] - (scores[rear] - 1);
             * count = scores[front] - scores[rear] + 1
             */
            count += (scores[front] - scores[rear] + 1);
            scores[front] = scores[rear] - 1;
        }

        System.out.print(count);
    }
}