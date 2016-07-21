
/*Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].*/

public class Wiggle_sort_280 {

	public static void main(String[] args) {
		int[] arr={3,5,2,1,6,4};
		boolean great=true;
		for(int i=1;i<arr.length;i++){
			if((great && arr[i]<arr[i-1])||(!great && arr[i]>arr[i-1])){
				int temp=arr[i];
				arr[i]=arr[i-1];
				arr[i-1]=temp;
			}
			great=!great;
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

}
