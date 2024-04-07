import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int tmp, avg, mode = 0, scope, weightSum = 0;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            tmp = Integer.parseInt(br.readLine());
            array[i] = tmp;
            if (!hashMap.containsKey(tmp)) {
                hashMap.put(tmp, 1);
            }
            else {
                hashMap.put(tmp, hashMap.get(tmp) + 1);
            }
        }
        for (int x : hashMap.keySet()) {
            weightSum += x * hashMap.get(x);
        }
        avg = (int)Math.round((double)weightSum / n);
        sb.append(avg).append("\n");
        Arrays.sort(array);
        sb.append(array[n / 2]).append("\n");
        int maxWeight = 0;
        for (int x : hashMap.keySet()) {
            if (maxWeight < hashMap.get(x)) {
                maxWeight = hashMap.get(x);
                mode = x;
            }
        }
        int counter = 0;
        for (int x : hashMap.keySet()) {
            if (hashMap.get(x) == maxWeight) {
                counter++;
            }
        }
        HashSet<Integer> number = new HashSet<>();
        if (counter >= 2) {
            for (int x : hashMap.keySet()) {
                if (hashMap.get(x) == maxWeight) {
                    number.add(x);
                }
            }
            Integer[] arr;
            arr = number.toArray(new Integer[0]);
            Arrays.sort(arr);
            sb.append(arr[1]).append("\n");
        }
        else {
            sb.append(mode).append("\n");
        }
        int max = -4000;
        int min = 4000;
        for (int x : hashMap.keySet()) {
            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }
        }
        sb.append(max - min);
        System.out.print(sb);
    }
}
