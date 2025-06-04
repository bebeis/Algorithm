import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Integer>> map = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            map.computeIfAbsent(genres[i], k -> new ArrayList<>());
            map.get(genres[i]).add(i);
            
            countMap.put(genres[i], countMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        String[] arr = map.keySet().toArray(new String[map.size()]);
        Arrays.sort(arr, (s1, s2) -> countMap.get(s2) - countMap.get(s1));
        
        List<Integer> result = new ArrayList<>();
        for (String genre : arr) {
            List<Integer> musics = map.get(genre);
            Collections.sort(musics, (x1, x2) -> {
                if (plays[x1] == plays[x2]) return x1 - x2;
                else return plays[x2] - plays[x1];
            });
            for (int i = 0; i < 2 && i < musics.size(); i++) {
                result.add(musics.get(i));
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}