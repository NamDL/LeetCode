import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> sol = new ArrayList<>();
        if(strs.length==0) return sol;
        Map<String, List<String>> map= new HashMap<>();
        for(int i=0;i<strs.length;i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            List<String> list = map.getOrDefault(String.valueOf(s), new ArrayList<>());
            list.add(strs[i]);
            map.put(String.valueOf(s), list);
        }
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            sol.add(entry.getValue());
        }
        return sol;
    }
}
