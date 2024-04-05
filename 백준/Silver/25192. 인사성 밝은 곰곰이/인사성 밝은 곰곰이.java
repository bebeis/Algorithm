import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hashSet = new HashSet<>();
        String temp = br.readLine();
        int count = 0;
        for (int i = 1; i < n; i++) {
            temp = br.readLine();
            if (temp.equals("ENTER")) {
                count += hashSet.size();
                hashSet.clear();
            }
            else {
                hashSet.add(temp);
            }
        }
        count += hashSet.size();
        System.out.print(count);
    }
}