
/*Given an array of n integers where n > 1, nums, return an array output such that output[i] is 
 * equal to the product of all the elements of nums except nums[i].Solve it without division and in O(n) and 
 * in costant space. For example, given [1,2,3,4], return [24,12,8,6].*/

public class Product_of_Array_Except_Self_238 {
	
	public static void main(String[] args) {
		int[] arr= {1,2,3,4};
		int[] sol= new int[arr.length];
		sol[arr.length-1]=1;
		for(int i=arr.length-2;i>=0;i--){
			sol[i]=sol[i+1]*arr[i+1];
		}
		int prod=1;
		for(int i=0;i<arr.length;i++){
			sol[i]=sol[i]*prod;
			prod=prod*arr[i];
		}
		for(int i:sol){
			System.out.println(i);
		}
	}
}
