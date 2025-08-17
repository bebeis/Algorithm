import java.io.*;
import java.util.*;

// 비교 할 때 오타 때문에 틀림;;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<NameScore> input = new ArrayList<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int ko = Integer.parseInt(st.nextToken());
            int en = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            input.add(new NameScore(name, ko, en, math));
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(input);
        input.forEach(d -> sb.append(d.name + "\n"));
        System.out.print(sb);
    }

    static class NameScore implements Comparable<NameScore> {
        String name;
        int koScore;
        int enScore;
        int mathScore;

        public NameScore(String name, int ko, int en, int math) {
            this.name = name;
            koScore = ko;
            enScore = en;
            mathScore = math;
        }

        @Override
        public int compareTo(NameScore target) {
            if (this.koScore != target.koScore) {
                return target.koScore - this.koScore;
            } else if (this.enScore != target.enScore) {
                return this.enScore - target.enScore;
            } else if (this.mathScore != target.mathScore) {
                return target.mathScore - this.mathScore;
            }
            return this.name.compareTo(target.name);
        }
    }
}