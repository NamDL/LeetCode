import java.util.*;

public class StringPartition {

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<S.length();i++) {
            map.put(S.charAt(i), i);
        }

        List<Integer> sol= new ArrayList<>();
        for(int i=0;i<S.length();) {
            int pos = findPos(i, S, map, map.get(S.charAt(i)));
            sol.add(pos-i+1);
            i=pos+1;
        }
        return sol;
    }

    private static int findPos(int start, String str, Map<Character, Integer> map, int end) {
        Set<Character> set = new HashSet<>();
        set.add(str.charAt(start));
        int i=start+1;
        while(i<=end) {
            char s = str.charAt(i);
            if(!set.contains(s)) {
                set.add(s);
                end=Math.max(end, map.get(s));
            }
            i++;
        }
        return end;
    }
}
