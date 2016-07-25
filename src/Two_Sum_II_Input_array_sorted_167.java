

/*56.	Given an array of integers that is already sorted in ascending order, find two numbers 
 * such that they add up to a specific target number. The function twoSum should return indices of the two
 *  numbers such that they add up to the target, where index1 must be less than index2. Please note that your
 *   returned answers (both index1 and index2) are not zero-based. You may assume that each input would 
 *   have exactly one solution. Input: numbers={2, 7, 11, 15}, target=9.*/


public class Two_Sum_II_Input_array_sorted_167 {

	public static void main(String[] args) {
		int[] arr={2,7,11,15};
		int target=9;
		int i=0,j=arr.length-1;
		while(i<j){
			int sum=arr[i]+arr[j];
			if(sum<target) i++;
			else if(sum>target) j--;
			else{
				System.out.println(i+" "+j);
				break;
			}
		}

	}

}
