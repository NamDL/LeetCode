import java.util.*;

public class MostCommonWord {
    public static void main(String[] args) {
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
        Map<String, Integer> map = new HashMap<String, Integer>();
        Set<String> set = new HashSet<>();
        for(String str: banned) {
            set.add(str.toLowerCase());
        }
        for (String s : paragraph.replaceAll("\\p{Punct}", " ").split(" ")) {
            if (!set.contains(s.toLowerCase()) && !s.isEmpty()) {
                map.put(s.toLowerCase(), map.getOrDefault(s.toLowerCase(), 0)+1);
            }
        }
        System.out.println(map.entrySet().stream().max(Comparator.comparingInt(Map.Entry<String, Integer>::getValue)).get().getKey());
    }
}
