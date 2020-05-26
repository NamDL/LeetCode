import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.*;

public class ShortChange {

    public static void main(String[] args) {


          int[] coin={1,5, 2};
        int amount=11;
        int sum=0, count=0, i=0;

        int[] coins = new int[coin.length];
        int index=0;
        for (int k=coin.length-1; k>=0;k--) {
            coins[index++]=coin[k];
        }
        if(coins[i] > amount) System.out.println(-1);
        while(sum<=amount && i<coins.length){
            if(coins[i]+sum <= amount) {
                sum+=coins[i];
                count++;
                if(sum==amount) break;
            } else {
                i++;
            }
        }
        Instant now = Instant.now();
        Instant later = Instant.now().plus(Duration.ofHours(1));
        long diff = ChronoUnit.HOURS.between(later, now);
        if(sum!=amount) System.out.println(-1);
        System.out.println(count);
    }

    private int[] reverseArray(int[] arr) {
        int[] ret=new int[arr.length];
        int index=0;
        for (int i=arr.length-1; i>=0;i--) {
            ret[index++]=arr[i];
        }
        return ret;
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[]{0, K});

        Map<Integer, Integer> dist = new HashMap();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            if (graph.containsKey(node))
                for (int[] edge: graph.get(node)) {
                    int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d+d2, nei});
                }
        }

        if (dist.size() != N) return -1;
        int ans = 0;
        for (int cand: dist.values())
            ans = Math.max(ans, cand);
        return ans;
    }
}
