import java.util.PriorityQueue;
import java.util.Queue;

public class HitCounter {

    Queue<Integer> queue;

    public HitCounter() {
        queue = new PriorityQueue<>();
    }

    public static void main(String[] args) {
        HitCounter ht = new HitCounter();
        ht.hit(1);
        ht.hit(2);
        ht.hit(3);
        ht.hit(300);
        System.out.println(ht.getHits(301));
    }

    public void hit(int timestamp) {
        queue.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!queue.isEmpty() && timestamp-queue.peek() >= 300) {
            queue.poll();
        }
        return queue.size();
    }

}
