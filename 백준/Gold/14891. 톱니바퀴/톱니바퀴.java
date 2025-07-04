import java.io.*;
import java.util.*;

// string.split("")의 첫 번째 요소는 빈 문자열이다!!! 주의!!!

public class Main {

    // N극: 0, S극: 1
    static Wheel[] wheels = new Wheel[4];
    static int k;
    static int score = 0;
    final static int COUNTER_WISE = -1;
    final static int CLOCK_WISE = 1;
    final static int NOTHING = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            wheels[i] = new Wheel(br.readLine());
        }
        k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            for (int i = 0; i < 4; i++) {
                wheels[i].rotateStatus = NOTHING;
            }
            String[] parts = br.readLine().split(" ");
            int no = Integer.parseInt(parts[0]) - 1;
            int dir = Integer.parseInt(parts[1]);
            wheels[no].rotateStatus = dir;

            // [6 (2] - [6) (2] - [6) (2] - [6) 2]

            // no 오른쪽에 있는 바퀴들의 회전
            for (int i = no + 1; i < 4; i++) { // i: 오른쪽 바퀴
                int j = i - 1; // 왼쪽 바퀴
                int leftPole = wheels[j].getRightPole();
                int rightPole = wheels[i].getLeftPole();

                if (leftPole == rightPole) {
                    break;
                }

                if (wheels[j].rotateStatus == COUNTER_WISE) { 
                    // 왼쪽 바퀴가 직전에 반시계로 돌았다면 오른쪽 바퀴는 시계방향
                    wheels[i].rotateStatus = CLOCK_WISE;
                } else {
                    wheels[i].rotateStatus = COUNTER_WISE;
                }
            }

            // no 왼쪽에 있는 바퀴들의 회전
            for (int i = no; i >= 1; i--) { // i: 오른쪽 바퀴
                int j = i - 1; // 왼쪽 바퀴
                int leftPole = wheels[j].getRightPole();
                int rightPole = wheels[i].getLeftPole();

                if (leftPole == rightPole) {
                    break;
                }

                if (wheels[i].rotateStatus == COUNTER_WISE) { 
                    // 오른쪽 바퀴가 직전에 반시계로 돌았다면 왼쪽 바퀴는 시계방향
                    wheels[j].rotateStatus = CLOCK_WISE;
                } else {
                    wheels[j].rotateStatus = COUNTER_WISE;
                }
            }

            for (Wheel wheel: wheels) {
                if (wheel.rotateStatus == CLOCK_WISE) {
                    wheel.clockRotate();
                } else if (wheel.rotateStatus == COUNTER_WISE) {
                    wheel.counterRotate();
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            if (wheels[i].isSPole()) {
                score += (1 << i);
            }
        }
        System.out.print(score);
    }

    static class Wheel {

        int[] poles = new int[8];
        int rotateStatus = 0;

        public Wheel(String input) {
            for (int j = 0; j < 8; j++) {
                poles[j] = input.charAt(j) - '0';
            }
        }

        public void counterRotate() {
            int first = poles[0];
            for (int i = 1; i < 8; i++) {
                poles[i - 1] = poles[i];
            }
            poles[7] = first;
        }

        public void clockRotate() {
            int last = poles[7];
            for (int i = 7; i >= 1; i--) {
                poles[i] = poles[i - 1];
            }
            poles[0] = last;
        }

        public boolean isSPole() {
            return poles[0] == 1;
        }

        public int getLeftPole() {
            return poles[6];
        }

        public int getRightPole() {
            return poles[2];
        }
    }
}
