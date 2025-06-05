import java.util.*;

class Solution {
    Map<String, Integer> stoi = new HashMap<>();
    Map<Integer, String> itos = new HashMap<>();
    List<List<Integer>> adj = new ArrayList<>();
    boolean[] usedTicket;                      
    List<Integer> currentPath; 
    List<Integer> answer;
    int ticketsCount;
    String[][] tickets;             

    public void dfs(int curNode, int depth) {
        currentPath.add(curNode);

        if (depth == ticketsCount + 1) {
            answer = new ArrayList<>(currentPath);
            return;
        }

        for (int ticketIdx : adj.get(curNode)) {
            if (!usedTicket[ticketIdx]) {
                usedTicket[ticketIdx] = true;
                String destCode = tickets[ticketIdx][1];
                int nxtNode = stoi.get(destCode);

                dfs(nxtNode, depth + 1);

                if (answer != null && !answer.isEmpty()) {
                    return;
                }

                usedTicket[ticketIdx] = false;
            }
        }

        currentPath.remove(currentPath.size() - 1);
    }

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;    
        ticketsCount = tickets.length;

        TreeSet<String> airportSet = new TreeSet<>();
        for (String[] t : tickets) {
            airportSet.add(t[0]);
            airportSet.add(t[1]);
        }
        int idx = 0;
        for (String name : airportSet) {
            stoi.put(name, idx);
            itos.put(idx, name);
            idx++;
        }

        for (int i = 0; i < idx; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < ticketsCount; i++) {
            String from = tickets[i][0];
            int fromIdx = stoi.get(from);
            adj.get(fromIdx).add(i);
        }

        for (int node = 0; node < idx; node++) {
            Collections.sort(adj.get(node), (a, b) -> {
                String destA = tickets[a][1];
                String destB = tickets[b][1];
                return destA.compareTo(destB);
            });
        }

        usedTicket = new boolean[ticketsCount];
        currentPath = new ArrayList<>();
        answer = new ArrayList<>();

        dfs(stoi.get("ICN"), 1);

        return answer.stream()
                     .map(idxNode -> itos.get(idxNode))
                     .toArray(String[]::new);
    }
}