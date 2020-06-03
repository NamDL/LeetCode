import java.util.*;

//https://leetcode.com/problems/critical-connections-in-a-network/
public class CriticalConnections {

    public static void main(String[] args) {
        List<List<Integer>> connections = new ArrayList<>();
        //[[0,1],[1,2],[2,0],[1,3]]
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));
        List<List<Integer>> sol = new ArrayList<>();
        List<List<Integer>> copy = new ArrayList<>(connections);


        //remove edge i
        for(int i=0;i<connections.size();i++) {
            List<Integer> removedEdge = connections.get(i);
            copy.remove(removedEdge);
            boolean critical = checkIfCritical(copy);
            if(critical) {
                sol.add(removedEdge);
            }
            copy.add(removedEdge);
        }
        System.out.println(sol);
    }

    private static boolean checkIfCritical(List<List<Integer>> connections) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[4];
        Map<Integer,List<Integer>> map = buildMap(connections);
        stack.push(connections.get(0).get(0));

        while(!stack.isEmpty()) {
            int vertex=stack.pop();
            visited[vertex]=true;
            List<Integer> reachable = map.get(vertex);
            for (Integer integer : reachable) {
                if (!visited[integer]) {
                    stack.push(integer);
                }
            }
        }
        for (boolean b : visited) {
            if (!b) return true;
        }
        return false;
    }

    private static Map<Integer, List<Integer>> buildMap(List<List<Integer>> connections) {
        Map<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (List<Integer> connection : connections) {
            List<Integer> list0 = map.getOrDefault(connection.get(0), new ArrayList<>());
            List<Integer> list1 = map.getOrDefault(connection.get(1), new ArrayList<>());

            list0.add(connection.get(1));
            list1.add(connection.get(0));

            map.put(connection.get(0), list0);
            map.put(connection.get(1), list1);
        }
        return map;
    }
}
