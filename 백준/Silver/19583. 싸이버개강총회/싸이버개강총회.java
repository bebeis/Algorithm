import java.io.*;
import java.util.*;
import java.time.*;

/**
 *  n <= 100,000
 *  O(nlogn) 이하로 풀이
 */

public class Main {

    static LocalTime S;
    static LocalTime E;
    static LocalTime Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] times = br.readLine().split(" ");
        S = LocalTime.parse(times[0]);
        E = LocalTime.parse(times[1]);
        Q = LocalTime.parse(times[2]);

        Set<String> beforeEntry = new HashSet<>();
        Set<String> finalEntry = new HashSet<>();
    
        String chatLog;
        while ((chatLog = br.readLine()) != null) {
            String[] parts = chatLog.split(" ");
            LocalTime chatTime = LocalTime.parse(parts[0]);
            String name = parts[1];
            if (chatTime.isBefore(S) || chatTime.equals(S)) {
                beforeEntry.add(name);
            }
            if ((chatTime.isAfter(E) || chatTime.equals(E)) && (chatTime.isBefore(Q) || chatTime.equals(Q))) {
                if (beforeEntry.contains(name)) {
                    finalEntry.add(name);
                }
            }
        }

        System.out.print(finalEntry.size());
    }
}
