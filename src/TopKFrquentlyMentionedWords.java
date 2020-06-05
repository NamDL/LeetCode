import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TopKFrquentlyMentionedWords {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        int k = 2;
        String[] keywords1 = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews1 = {
        "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular."};



        Set<String> set = new HashSet<>(Arrays.asList(keywords1));
        for(String s: reviews1) {
            String[] str = s.split(" ");
            Set<String> perReview = new HashSet<>();
            for (String st: str) {
                if(!perReview.contains(st) && set.contains(st)) {
                    perReview.add(st);
                    map.put(st, map.getOrDefault(st,0)+1);
                }
            }
        }
        PriorityQueue<String> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for(String s: map.keySet()) {
            heap.offer(s);
            if(heap.size()>k) {
                heap.poll();
            }
        }
        List<String> sol = new ArrayList<>(heap);
        //Collections.reverse(sol);
        System.out.println(sol);
    }
}
