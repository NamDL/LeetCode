import java.util.*;
import java.util.stream.Collectors;

public class Dominoes {

    public static void main(String[] args) {
        char a='a';
        int[][] dominoes = {{1,1},{2,2},{1,1},{1,2},{1,2},{1,1}};
        int count=0;
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0;i<dominoes.length;i++) {
            String ab = String.valueOf(dominoes[i][0])+ dominoes[i][1];
            List<Integer> list = map.getOrDefault(ab, new ArrayList<>());
            list.add(i);
            map.put(ab,list);
        }
        for(int i=0;i<dominoes.length;i++) {
            String ab = String.valueOf(dominoes[i][0])+ dominoes[i][1];
            String ba = new StringBuilder(ab).reverse().toString();
            if(map.get(ab)!=null) {
                List<Integer> pos = map.get(ab);
                for(int j: pos) {
                    if(i<j) count+=1;
                }
            }
            if(map.get(ba)!=null && ab.compareTo(ba)!=0) {
                List<Integer> pos = map.get(ba);
                for(int j: pos) {
                    if(i<j) count+=1;
                }
            }
        }
        System.out.println(count);
    }
}
