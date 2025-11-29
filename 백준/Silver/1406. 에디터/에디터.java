import java.util.*;
import java.io.*;
import java.util.function.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        List<Character> chars = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            chars.add(input.charAt(i));
        }

        ListIterator<Character> it = chars.listIterator(input.length());
        Map<Character, Consumer<Character>> commandMap = new HashMap<>();
        commandMap.put('L', c -> {
            if (it.hasPrevious()) {
                it.previous();
            }
        });

        commandMap.put('D', c -> {
            if (it.hasNext()) {
                it.next();
            }
        });

        commandMap.put('B', c -> {
            if (it.hasPrevious()) {
                it.previous();
                it.remove();
            }
        });

        commandMap.put('P', c -> {
            it.add(c);
        });

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            String line = br.readLine();
            commandMap.get(line.charAt(0)).accept(line.charAt(0) == 'P' ? line.charAt(2) : ' ');
        }

        StringBuilder sb = new StringBuilder();
        chars.forEach(sb::append);
        System.out.print(sb);
    }
}