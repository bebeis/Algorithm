import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class StringC implements Comparable<StringC> {
        String word;
        public StringC(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(StringC o) {
            if (this.word.length() > o.word.length()) {
                return 1;
            }
            else if (this.word.length() < o.word.length()) {
                return -1;
            }
            else {
                return this.word.compareTo(o.word);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringC[] words = new StringC[n];
        for (int i = 0; i < n; i++) {
            words[i] = new StringC(br.readLine());
        }
        Arrays.sort(words);
        sb.append(words[0].word).append("\n");
        for (int i = 1; i < n; i++) {
            if (!words[i].word.equals(words[i - 1].word)) {
                sb.append(words[i].word).append("\n");
            }
        }
        System.out.print(sb);
    }
}
