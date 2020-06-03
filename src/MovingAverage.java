import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MovingAverage {
    Queue<Integer> queue;
    int sum;
    int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size=size;
        sum=0;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        queue.offer(val);
        if(queue.size() > size) {
            int top=queue.poll();
            sum=sum-top;
        }
        sum+=val;
        if(sum==0) return 0;
        return (double) sum/queue.size();
    }
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(1);
        System.out.println(movingAverage.next(4));
        System.out.println(movingAverage.next(0));
        System.out.println(movingAverage.next(3));

    }
}
