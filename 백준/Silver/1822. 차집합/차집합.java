import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int na;
    static int nb;

    static int[] a = new int[500002];
    static int[] b = new int[500002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        na = Integer.parseInt(st.nextToken());
        nb = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < na; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nb; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(b, 0, nb);
        List<Integer> result = Arrays.stream(a, 0, na)
            .filter(v -> Arrays.binarySearch(b, 0, nb, v) < 0)
            .sorted()
            .boxed()
            .collect(Collectors.toList());
        
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');
        result.forEach(v -> sb.append(v).append(' '));

        System.out.print(sb);
    }
}