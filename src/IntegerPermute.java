import java.util.ArrayList;
import java.util.List;

public class IntegerPermute {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        recur(0,nums,sol);
        return sol;

    }

    private static void recur(int pos, int[] nums, List<List<Integer>> sol) {
        if(pos == nums.length-1) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++) {
                list.add(nums[i]);
            }
            sol.add(list);
            return;
        }
        for(int i=pos;i<nums.length;i++) {
            swap(nums, pos, i);
            recur(pos+1, nums, sol);
            swap(nums, pos, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        List<List<Integer>> sol = permute(new int[]{1,2,3});
    }
}
