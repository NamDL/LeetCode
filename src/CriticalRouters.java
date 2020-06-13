import java.util.*;

public class CriticalRouters {

    public static void main(String[] args) {
        int[][] edges= {{0, 1},{0, 2},{1, 3},{2, 3},{2, 5},{5, 6},{3, 4}};
        int nodeNum=7;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited= new boolean[nodeNum];
        int[] rank= new int[nodeNum];
        for(int i=0;i<nodeNum;i++) {
            rank[i]=i;
        }
        Set<Integer> sol = new HashSet<>();
        dfs(map, 0, 0, rank, visited, -1, sol);
        System.out.println(sol);
    }
    private static void dfs(Map<Integer, List<Integer>> map, int node, int curRank, int[] rank, boolean[] visited, int prevNode, Set<Integer> sol) {
        rank[node]=curRank;
        visited[node]=true;
        for(int toNode: map.get(node)) {
            if(toNode==prevNode) continue;
            if(!visited[toNode]) dfs(map, toNode, curRank+1, rank, visited, node, sol);
            rank[node] = Math.min(rank[node], rank[toNode]);
            if(rank[node]!=rank[toNode]) sol.add(node);
        }
    }
}
