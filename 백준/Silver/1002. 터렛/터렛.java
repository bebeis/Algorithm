import java.io.*;
import java.util.*;

/**
 * 조규현, 백승환 -> 터렛
 * 류재명 -> 상대
 * 상대까지의 거리, 터렛의 위치를 통해서, 상대가 위치할 수 있는 좌표의 수 구하기
 * Sol) 원을 그려서, 두 원의 접점이 2개인지, 1개인지, 0개 인지 찾는다.
 * - 두 원의 접점이 0개인 경우
 *  1. 내부에 있거나
 *  r2 - r1 > d
 *  2. 아에 바깥에서 접점이 없거나(외부에 있거나)
 *  r1 + r2 < d
 *  3. 동심원
 *  d = 0 && r1 != r2
 * - 두 원의 접점이 1개인 경우
 *  1. d = r1 + r2와 일치하는 경우(외접)
 *  2. d + r1 = r2, 즉 r2 - r1 = d
 * 
 * - 두 원의 접점이 무한대인 경우
 *  1. 원의 중심이 같고 r1 == r2인 경우
 * 
 * - 두 원의 접점이 2개인 경우
 *  r1 + r2 > d 이고, r1 - r2 < d
 */

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            
            double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
            // r1 <= r2로 세팅
            if (r1 > r2) {
                int tmp = r1;
                r1 = r2;
                r2 = tmp;
            }

            // 두 원의 접점이 무한대인 경우
            // 원의 중심이 같고 r1 == r2인 경우
            if (x1 == x2 && y1 == y2 && r1 == r2)  {
                sb.append("-1\n");
            }
            // 두 원의 접점이 1개인 경우
            else if ((d == (r1 + r2)) || ((r2 - r1) == d)) {
                sb.append("1\n");
            } 
            // 두 원의 접점이 2개인 경우
            else if (((r1 + r2) > d) && ((r2 - r1) < d)) {
                sb.append("2\n");
            } 
            // 그 외(두원의 접점이 0개)
            else {
                sb.append("0\n");
            }
        }
        System.out.print(sb);
    }
}
