
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        LinkedList<Character> list = new LinkedList<>();
        for (char c : input.toCharArray()) list.add(c);

        ListIterator<Character> cursor = list.listIterator(list.size());

        Map<String, Runnable> noArgCommands = new HashMap<>();
        Map<String, Consumer<Character>> charCommands = new HashMap<>();

        charCommands.put("P", cursor::add);

        noArgCommands.put("L", () -> {
            if (cursor.hasPrevious()) cursor.previous();
        });

        noArgCommands.put("D", () -> {
            if (cursor.hasNext()) cursor.next();
        });

        noArgCommands.put("B", () -> {
            if (cursor.hasPrevious()) {
                cursor.previous();
                cursor.remove();
            }
        });

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String cmd = br.readLine();

            char type = cmd.charAt(0);

            if (type == 'P') {
                char x = cmd.charAt(2);
                charCommands.get("P").accept(x);
            } else {
                noArgCommands.get(String.valueOf(type)).run();
            }
        }

        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        System.out.print(sb);
    }
}
