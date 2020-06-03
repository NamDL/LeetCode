import java.util.*;
import java.util.stream.Collectors;

public class NextGreater {
    public static void main(String[] args) {
        int[] nums = {1,4,3,2,0,6,5};
        List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i=0;i<nums.length-1;i++) {
            arr.add(nums[i]);
        }
        int ts=0;
        Queue<Integer> queue = new PriorityQueue<>();
        while (!queue.isEmpty() && ts-queue.peek() > 300) {
            queue.poll();
        }
        String myStr1 = "i";
        String myStr2 = "love";
        System.out.println(myStr1.compareTo(myStr2));
    }
}
