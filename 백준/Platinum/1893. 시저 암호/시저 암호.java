import java.io.*;
import java.util.*;

/**
 * 원문의 각 글자가 어떤 일정한 수만큼의 뒷 순서의 알파벳으로 시프트되는 방식
 * ex) 3시프트: A -> D, B -> E, ...
 * 아라벳 순서, 원문, 암호문 주어짐
 * 암호문 해독 시 (원본 한 번 등장) 추측 가능한 시프트 값 찾기
 */

/**
 * 암호화 방법이 없으면(만족하는 시프트 없으면 ) "no solution"
 * 오직 하나의 시프트 값 -> "unique: value"
 * 여러 개 존재 -> "ambiguous: " 뒤에 오름차순 목록
 */

/**
 * solution
 * 암호문을 역으로 쉬프트했을 때 원문이 한 번 등장해야 함
 * 쉬프트 경우의 수 : 61가지
 * O(WS)로는 불가능 
 * O(W + S)로 해결해야 함. 각 시프트 케이스 61가지에 대해 50만번 수행해도 1억 안넘음 -> KMP 사용
 * 1. 먼저 암호문을 역으로 쉬프트 시킨다.
 * 2. KMP로 원문이 등장하는 횟수를 찾는다.
 * 3. 0 -> no solution, 1 -> unique value, 2개 이상 -> ambiguous
 */

public class Main {

    public static int[] failure(String s) {
        int[] f = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = f[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                f[i] = ++j;
            }
        }
        return f;
    }

    public static boolean kmp(char[] decrypt, String plain) {
        int[] f = failure(plain);
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < decrypt.length; i++) {
            while (j > 0 && decrypt[i] != plain.charAt(j)) {
                j = f[j - 1];
            }

            if (decrypt[i] == plain.charAt(j)) {
                j++;
                if (j == plain.length()) {
                    cnt++;
                    if (cnt >= 2) return false;
                    j = f[j - 1];
                }
            }
        }

        return cnt == 1;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String orderLine = br.readLine(); 
            int[] ctoi = new int[256]; // char -> index 매핑
            Arrays.fill(ctoi, -1);
            for (int i = 0; i < orderLine.length(); i++) {
                ctoi[orderLine.charAt(i)] = i;
            }

            String plain = br.readLine();
            String cyper = br.readLine();

            List<Integer> ways = new ArrayList<>();

            for (int shift = 0; shift < orderLine.length(); shift++) {
                char[] cyperArr = cyper.toCharArray();
                for (int j = 0; j < cyperArr.length; j++) {
                    int nth = ctoi[cyperArr[j]];
                    int prevTh = (nth - shift) % orderLine.length();
                    if (prevTh < 0) prevTh += orderLine.length();
                    cyperArr[j] = orderLine.charAt(prevTh);
                }

                if (kmp(cyperArr, plain)) {
                    ways.add(shift);
                }
            }

            if (ways.size() == 0) {
                sb.append("no solution\n");
            } else if (ways.size() == 1) {
                sb.append("unique: ").append(ways.get(0)).append('\n');
            } else {
                sb.append("ambiguous:");
                for (int w : ways) sb.append(' ').append(w);
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}
