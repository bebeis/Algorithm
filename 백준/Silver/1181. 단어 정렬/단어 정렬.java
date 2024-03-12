import java.io.*;
import java.util.*;

public class Main {

    /* 
    이렇게 할 필요 없이 단순 sort를 재정의 해주면 된다
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
    */ 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()){
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });
        sb.append(words[0]).append("\n");
        for (int i = 1; i < n; i++) {
            if (!words[i].equals(words[i - 1])) {
                sb.append(words[i]).append("\n");
            }
        }
        System.out.print(sb);
    }
}
